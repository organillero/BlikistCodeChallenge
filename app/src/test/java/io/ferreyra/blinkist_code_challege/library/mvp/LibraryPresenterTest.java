package io.ferreyra.blinkist_code_challege.library.mvp;

import com.twistedequations.mvl.rx.AndroidRxSchedulers;
import com.twistedequations.mvl.rx.TestAndroidRxSchedulers;

import org.junit.Before;

import static org.mockito.Mockito.mock;

/**
 * Created by carlos on 10/31/17.
 */

public class LibraryModelTest {

    //Class to test
    private LibraryPresenter presenter;

    //To be mocked
    private LibraryModel model;
    private LibraryView view;

    //TestAndroidSchedulers that force everything onto the current thread
    private AndroidRxSchedulers schedulers = new TestAndroidRxSchedulers();

    @Before
    private void setUp() throws Exception{
        model = mock(LibraryModel.class);
        view = mock(LibraryView.class);
        presenter = new LibraryPresenter(view, model, schedulers);
    }
}
