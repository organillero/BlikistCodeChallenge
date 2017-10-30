package io.ferreyra.blinkist_code_challege.library.mvp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.ferreyra.blinkist_code_challege.R;
import io.ferreyra.blinkist_code_challege.network.model.BlkBook;


/**
 * Created by carlos on 10/19/17.
 */


@SuppressLint("ViewConstructor")
public class LibraryView extends ConstraintLayout {

    private final LibraryAdapter adapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    public LibraryView(Activity activity, LibraryAdapter adapter) {
        super(activity);
        inflate(getContext(), R.layout.activity_library, this);
        ButterKnife.bind(this);

        this.adapter = adapter;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }


    public void setBooks (List<BlkBook> events){
        adapter.setBooks(events);
    }
//
//    public Observable<SGEvent> getEventViewClickedObservable (){
//        return this.adapter.getEventViewClickedObservable();
//    }

}
