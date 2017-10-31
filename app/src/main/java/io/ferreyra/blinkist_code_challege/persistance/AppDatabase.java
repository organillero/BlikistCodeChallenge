package io.ferreyra.blinkist_code_challege.persistance;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;


import io.ferreyra.blinkist_code_challege.model.BlkBook;
import io.ferreyra.blinkist_code_challege.persistance.utils.Converters;

/**
 * Created by carlos on 10/30/17.
 */

@Database(entities = {BlkBook.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract BooksDAO booksDAO();
}
