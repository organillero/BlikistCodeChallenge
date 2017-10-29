package io.ferreyra.blinkist_code_challege.dagger;

/**
 * Created by carlos on 10/28/17.
 */

import com.squareup.picasso.Picasso;

import dagger.Component;
import io.ferreyra.blinkist_code_challege.dagger.modules.AppModule;
import io.ferreyra.blinkist_code_challege.dagger.modules.GsonModule;
import io.ferreyra.blinkist_code_challege.dagger.modules.NetworkModule;

@AppScope
@Component(modules = { AppModule.class , NetworkModule.class, GsonModule.class})
public interface  AppComponent {

    Picasso picasso();


}
