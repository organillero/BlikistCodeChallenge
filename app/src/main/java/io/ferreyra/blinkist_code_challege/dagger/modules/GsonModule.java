package io.ferreyra.blinkist_code_challege.dagger.modules;

/**
 * Created by carlos on 10/28/17.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import io.ferreyra.blinkist_code_challege.dagger.AppScope;
import io.ferreyra.blinkist_code_challege.network.BlkAdapterAdapter;

@Module
public class GsonModule {

    @AppScope
    @Provides
    public Gson providesGson (){
        return new GsonBuilder()
                .registerTypeAdapterFactory(BlkAdapterAdapter.create())
                .create();

    }
}
