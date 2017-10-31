package io.ferreyra.blinkist_code_challege.library.mvp;

import android.util.Log;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by carlos on 10/19/17.
 */

public class LibraryPresenter {

    private final CompositeSubscription compositeSubscription = new CompositeSubscription();

    private final LibraryView view;
    private final LibraryModel model;

    public LibraryPresenter(LibraryView view, LibraryModel model) {
        this.view = view;
        this.model = model;
    }

    public void onCreate() {
        compositeSubscription.add(getBooks());

    }

    public void onDestroy() {
        compositeSubscription.clear();
    }


    private Subscription getBooks() {
        return model.getBooks()
                //.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        books -> view.setBooks(books),
                        error ->  Log.e("Error", error.getLocalizedMessage())
                );
    }

}
