package io.ferreyra.blinkist_code_challege.dagger.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import io.ferreyra.blinkist_code_challege.dagger.AppScope;
import io.ferreyra.blinkist_code_challege.persistance.AppDatabase;

/**
 * Created by carlos on 10/30/17.
 */

@Module
public class PersistanceModule {

    @AppScope
    @Provides
    public AppDatabase providesAppDataBase( Context context){
        return Room.databaseBuilder(context, AppDatabase.class, "books-db").build();
    }
}
