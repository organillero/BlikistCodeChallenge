package io.ferreyra.blinkist_code_challege.persistance;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.ferreyra.blinkist_code_challege.model.BlkBook;
import rx.Single;


/**
 * Created by carlos on 10/30/17.
 */

@Dao
public interface  BooksDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     void insert(List<BlkBook> universities);

    @Query("SELECT * FROM BlkBook")
    List<BlkBook> fetchAllData();

}
