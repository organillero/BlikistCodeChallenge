package io.ferreyra.blinkist_code_challege.network;

import java.util.List;

import io.ferreyra.blinkist_code_challege.network.model.BlkBook;
import io.ferreyra.blinkist_code_challege.network.model.BlkBooks;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by carlos on 10/29/17.
 */

public interface BlkApi {

    @GET("v4/books?updated_since_etag=15077351087000")
    Observable<BlkBooks> getBooks(@Query("skip") int skip, @Query("limit") int limit);
}
