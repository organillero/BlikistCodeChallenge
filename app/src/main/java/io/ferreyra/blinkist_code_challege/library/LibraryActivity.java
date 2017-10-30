package io.ferreyra.blinkist_code_challege.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import io.ferreyra.blinkist_code_challege.BlinkistApplication;
import io.ferreyra.blinkist_code_challege.R;
import io.ferreyra.blinkist_code_challege.library.dagger.DaggerLibraryComponent;
import io.ferreyra.blinkist_code_challege.library.dagger.LibraryModule;
import io.ferreyra.blinkist_code_challege.library.mvp.LibraryPresenter;
import io.ferreyra.blinkist_code_challege.library.mvp.LibraryView;

public class LibraryActivity extends AppCompatActivity {

    @Inject
    LibraryView view;

    @Inject
    LibraryPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        DaggerLibraryComponent.builder()
                .appComponent( ((BlinkistApplication) this.getApplication()).getComponent() )
                .libraryModule(new LibraryModule(this))
                .build()
                .inject(this)
        ;

        setContentView(view);
        presenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
