package io.ferreyra.blinkist_code_challege.persistance;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import io.ferreyra.blinkist_code_challege.model.BlkBook;

/**
 * Created by carlos on 10/30/17.
 */

@Database(entities = {BlkBook.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BooksDAO booksDAO();
}
