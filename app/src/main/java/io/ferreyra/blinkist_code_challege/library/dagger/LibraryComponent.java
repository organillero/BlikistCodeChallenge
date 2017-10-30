package io.ferreyra.blinkist_code_challege.library.dagger;

import dagger.Component;
import io.ferreyra.blinkist_code_challege.dagger.AppComponent;
import io.ferreyra.blinkist_code_challege.library.LibraryActivity;

/**
 * Created by carlos on 10/19/17.
 */

@LibraryScope
@Component( modules = {LibraryModule.class},
            dependencies = AppComponent.class)

public interface LibraryComponent {
    void inject(LibraryActivity activity);
}
