package io.ferreyra.blinkist_code_challege.library.mvp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.ferreyra.blinkist_code_challege.R;
import io.ferreyra.blinkist_code_challege.model.BlkBook;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by carlos on 10/20/17.
 */

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.ViewHolder> {

    private final Picasso picasso;

    public LibraryAdapter(Picasso picasso) {
        this.picasso = picasso;
    }

    private List<BlkBook> books = new ArrayList<>();


    public PublishSubject<BlkBook> mViewClickSubject = PublishSubject.create();

    public Observable<BlkBook> getEventViewClickedObservable() {
        return mViewClickSubject.asObservable();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_cover)
        public ImageView imageView;
        @BindView(R.id.item_tile)
        public TextView title;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, itemView);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.book_row_item, parent, false);

        ViewHolder vh = new ViewHolder(v);

        RxView.clicks(v)
                .takeUntil(RxView.detaches(parent))
                .map(__ -> (BlkBook) vh.itemView.getTag())
                .subscribe(mViewClickSubject);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            BlkBook book = books.get(position);
            this.picasso.load(book.getImageURL()).into(holder.imageView);
            holder.title.setText(book.getTitle());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    void setBooks(List<BlkBook> books ){
        this.books = books;
        notifyDataSetChanged();
    }
}
