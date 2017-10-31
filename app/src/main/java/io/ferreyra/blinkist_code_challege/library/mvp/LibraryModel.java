package io.ferreyra.blinkist_code_challege.library.mvp;

import java.util.List;

import io.ferreyra.blinkist_code_challege.model.BlkBook;
import io.ferreyra.blinkist_code_challege.model.BlkBooks;
import io.ferreyra.blinkist_code_challege.network.BlkApi;
import io.ferreyra.blinkist_code_challege.persistance.BooksDAO;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by carlos on 10/19/17.
 */

public class LibraryModel {

    private final BlkApi api;
    private final BooksDAO booksDAO;

    private List<BlkBook> memoryCache;

    public LibraryModel(BlkApi api, BooksDAO booksDAO) {
        this.api = api;
        this.booksDAO = booksDAO;
    }

    // Create our sequence for querying best available data
    Observable<List<BlkBook>> getBooks() {
        return Observable.concat(
                memoryObservable(),
                DBObservable(),
                networkObservable())
                .filter(
                        data -> data != null && data.size() >0 )
                .first();
    }


    private Observable<List<BlkBook>> networkObservable() {
        return api.getBooks(0, 50)
                .map(blkBooks -> blkBooks.getBooks())
                .subscribeOn(Schedulers.io())
                .doOnNext(data -> {
                    memoryCache = data;
                    booksDAO.insert(data);
                })
                .compose(logSource("NETWORK"));
    }

    private Observable<List<BlkBook>> DBObservable() {
        Observable<List<BlkBook>> observable = Observable.unsafeCreate(subscriber -> {
            subscriber.onNext(booksDAO.fetchAllData());
            subscriber.onCompleted();
        });
        return observable.subscribeOn(Schedulers.newThread()).compose(logSource("DB"));
    }

    private Observable<List<BlkBook>> memoryObservable() {
        Observable<List<BlkBook>> observable = Observable.unsafeCreate(subscriber -> {
            subscriber.onNext(memoryCache);
            subscriber.onCompleted();
        });
        return observable.subscribeOn(Schedulers.newThread()).compose(logSource("MEMORY"));
    }

    // Simple logging to let us know what each source is returning
    private Observable.Transformer<List<BlkBook>, List<BlkBook>> logSource(final String source) {
        return dataObservable -> dataObservable.doOnNext(data -> {
            if (data != null && data.size() >0  ) {
                System.out.println(source + " has the data you are looking for!");
            } else {
                System.out.println(source + " does not have any data.");
            }
        });

    }

}
