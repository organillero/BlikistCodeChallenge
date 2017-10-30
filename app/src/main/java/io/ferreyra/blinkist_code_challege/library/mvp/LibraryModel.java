package io.ferreyra.blinkist_code_challege.library.mvp;

import java.util.List;

import io.ferreyra.blinkist_code_challege.network.BlkApi;
import io.ferreyra.blinkist_code_challege.network.model.BlkBook;
import io.ferreyra.blinkist_code_challege.network.model.BlkBooks;
import rx.Observable;

/**
 * Created by carlos on 10/19/17.
 */

public class LibraryModel {

    private final BlkApi api;

    public LibraryModel(BlkApi api){
        this.api = api;
    }
    public Observable<BlkBooks> getBooks() {
        return api.getBooks(0,50);
    }

}
