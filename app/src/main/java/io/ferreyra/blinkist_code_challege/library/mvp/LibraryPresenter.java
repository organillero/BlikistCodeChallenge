package io.ferreyra.blinkist_code_challege.library.mvp;

import android.util.Log;

import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.DateTimeConstants;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.util.ArrayList;
import java.util.List;

import io.ferreyra.blinkist_code_challege.model.BlkBook;
import io.ferreyra.blinkist_code_challege.model.BlkBooks;
import io.ferreyra.blinkist_code_challege.model.Section;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
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

        return getSortedBooks()
                .map(listBooks -> {
                            List<Section> sections = new ArrayList<>();

                            int sectionWeek = -1;
                            int sectionYear = -1;
                            List<BlkBook> currentListBooks = new ArrayList<>();

                            for (int i = 0; i < listBooks.size(); i++) {

                                BlkBook book = listBooks.get(i);

                                int bookWeek = book.getPublishedAt().getWeekOfWeekyear();
                                int bookYear = book.getPublishedAt().getYear();

                                if (sectionWeek < bookWeek || sectionYear < bookWeek) {
                                    String header = DateTimeFormat.mediumDate().print(book.getPublishedAt().withDayOfWeek(DateTimeConstants.MONDAY));
                                    currentListBooks = new ArrayList<>();
                                    sections.add(new Section(header, currentListBooks));
                                    sectionWeek = bookWeek;
                                    sectionYear = bookYear;
                                }
                                currentListBooks.add(book);
                            }
                            return sections;
                        }
                )
                .observeOn(AndroidSchedulers.mainThread())
                //.doOnSubscribe() show progressBar
                //.doOnCompleted() hide progressBar
                .subscribe(
                        view::setBooksSections,
                        error -> Log.e("Error", error.getLocalizedMessage())
                );
    }


    private Observable<List<BlkBook>> getSortedBooks() {
        return model.getBooks()
                .flatMap(Observable::from)
                .sorted((book1, book2) -> book1.getPublishedAt().compareTo(book2.getPublishedAt()))
                .toList();

    }
}