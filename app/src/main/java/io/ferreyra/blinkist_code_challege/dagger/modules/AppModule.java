package io.ferreyra.blinkist_code_challege.dagger.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import io.ferreyra.blinkist_code_challege.dagger.AppScope;

/**
 * Created by carlos on 10/28/17.
 */

@Module
public class AppModule {

    private final Context context;

    public AppModule(Context context) {
        this.context = context;

    }

    @AppScope
    @Provides
    public Context context(){
        return context;
    }

}
