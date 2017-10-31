package io.ferreyra.blinkist_code_challege.library.mvp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.zakariya.stickyheaders.StickyHeaderLayoutManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.ferreyra.blinkist_code_challege.R;
import io.ferreyra.blinkist_code_challege.model.BlkBook;
import io.ferreyra.blinkist_code_challege.model.Section;


/**
 * Created by carlos on 10/19/17.
 */


@SuppressLint("ViewConstructor")
public class LibraryView extends ConstraintLayout {

    private final LibraryStickyAdapter adapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    public LibraryView(Activity activity, LibraryStickyAdapter adapter) {
        super(activity);
        inflate(getContext(), R.layout.activity_library, this);
        ButterKnife.bind(this);

        this.adapter = adapter;

        StickyHeaderLayoutManager stickyHeaderLayoutManager = new StickyHeaderLayoutManager();
        stickyHeaderLayoutManager.setHeaderPositionChangedCallback(new StickyHeaderLayoutManager.HeaderPositionChangedCallback() {
            @Override
            public void onHeaderPositionChanged(int sectionIndex, View header, StickyHeaderLayoutManager.HeaderPosition oldPosition, StickyHeaderLayoutManager.HeaderPosition newPosition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    boolean elevated = newPosition == StickyHeaderLayoutManager.HeaderPosition.STICKY;
                    header.setElevation(elevated ? 8 : 0);
                }
            }
        });

        recyclerView.setLayoutManager(stickyHeaderLayoutManager);
        recyclerView.setAdapter(adapter);
    }


    public void setBooksSections(List<Section> sections){
      adapter.setBookSections(sections);

    }

    public void showProgressBar (){

    }

    public void hideProgressBar (){

    }

}
