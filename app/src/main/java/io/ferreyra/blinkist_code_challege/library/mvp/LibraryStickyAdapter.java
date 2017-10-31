package io.ferreyra.blinkist_code_challege.library.mvp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.zakariya.stickyheaders.SectioningAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.ferreyra.blinkist_code_challege.R;
import io.ferreyra.blinkist_code_challege.model.BlkBook;
import io.ferreyra.blinkist_code_challege.model.Section;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by carlos on 10/30/17.
 */

public class LibraryStickyAdapter extends SectioningAdapter {

    private final Picasso picasso;

    public LibraryStickyAdapter(Picasso picasso) {
        this.picasso = picasso;
    }
    private List<Section> bookSections = new ArrayList<>();

    public PublishSubject<BlkBook> mViewClickSubject = PublishSubject.create();

    public Observable<BlkBook> getEventViewClickedObservable() {
        return mViewClickSubject.asObservable();
    }

    public class ItemHolder extends SectioningAdapter.ItemViewHolder {

        @BindView(R.id.item_cover)
        public ImageView imageView;
        @BindView(R.id.item_tile)
        public TextView title;

        public ItemHolder(View v) {
            super(v);
            ButterKnife.bind(this, itemView);
        }
    }

    public class HeaderHolder extends SectioningAdapter.HeaderViewHolder {

        @BindView(R.id.section_name)
        public TextView title;

        public HeaderHolder(View v){
            super(v);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getNumberOfSections() {
        return bookSections.size();
    }

    @Override
    public int getNumberOfItemsInSection(int sectionIndex) {
        return bookSections.get(sectionIndex).getItems().size();
    }
    @Override
    public boolean doesSectionHaveHeader(int sectionIndex) {
        return true;
    }

    @Override
    public boolean doesSectionHaveFooter(int sectionIndex) {
        return false;
    }

    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.book_row_item, parent, false);
        return new ItemHolder(v);
    }

    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int headerType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.header_row, parent, false);
        return new HeaderHolder(v);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindItemViewHolder(SectioningAdapter.ItemViewHolder viewHolder, int sectionIndex, int itemIndex, int itemType) {
        BlkBook book = bookSections.get(sectionIndex).getItems().get(itemIndex);
        ItemHolder ivh = (ItemHolder) viewHolder;

        this.picasso.load(book.getImageURL()).into(ivh.imageView);
        ivh.title.setText(book.getTitle());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindHeaderViewHolder(SectioningAdapter.HeaderViewHolder viewHolder, int sectionIndex, int headerType) {
        Section s = bookSections.get(sectionIndex);

        HeaderHolder hvh = (HeaderHolder) viewHolder;
        hvh.title.setText(s.getHeader());
    }

    public void setBookSections (List<Section> bookSections){
        this.bookSections = bookSections;
        notifyAllSectionsDataSetChanged();
    }

}
