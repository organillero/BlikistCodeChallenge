package io.ferreyra.blinkist_code_challege;

import android.app.Application;

import io.ferreyra.blinkist_code_challege.dagger.AppComponent;
import io.ferreyra.blinkist_code_challege.dagger.DaggerAppComponent;
import io.ferreyra.blinkist_code_challege.dagger.modules.AppModule;

/**
 * Created by carlos on 10/29/17.
 */

public class BlinkistApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getComponent() {
        return appComponent;
    }

}
