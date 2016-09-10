package br.android.cericatto.booklisting.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.android.cericatto.booklisting.R;
import br.android.cericatto.booklisting.model.BookItem;
import br.android.cericatto.booklisting.model.ImageLink;
import br.android.cericatto.booklisting.model.VolumeInfo;
import br.android.cericatto.booklisting.utils.Utils;

/**
 * BookAdapter.java.
 *
 * @author Rodrigo Cericatto
 * @since Sep 9, 2016
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private List<BookItem> mItems;
    private Activity mActivity;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    public BookAdapter(Activity activity, List<BookItem> items) {
        mActivity = activity;
        mItems = items;
    }

    //--------------------------------------------------
    // Adapter Methods
    //--------------------------------------------------

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        BookItem item = mItems.get(position);

        setImage(holder, item);
        setTitle(holder, item);
        setAuthors(holder, item);
        setDate(holder, item);
        setDescription(holder, item);
    }

    @Override
    public int getItemCount() {
        if (mItems != null && mItems.size() > 0) {
            return mItems.size();
        }
        return 0;
    }

    //--------------------------------------------------
    // Methods
    //--------------------------------------------------

    private void setImage(ViewHolder holder, BookItem item) {
        VolumeInfo volumeInfo = item.getVolumeInfo();
        if (volumeInfo != null) {
            ImageLink imageLinks = volumeInfo.getImageLinks();
            if (imageLinks != null) {
                String url = imageLinks.getSmallThumbnail();
                if (!Utils.isEmpty(url)) {
                    Picasso.with(mActivity).load(url).placeholder(R.drawable.place_holder).into(holder.pictureImageView);
                }
            }
        }
    }

    private void setTitle(ViewHolder holder, BookItem item) {
        VolumeInfo volumeInfo = item.getVolumeInfo();
        if (volumeInfo != null) {
            String title = volumeInfo.getTitle();
            if (!Utils.isEmpty(title)) {
                holder.titleTextView.setText(title);
            } else {
                holder.titleLabelTextView.setVisibility(View.GONE);
            }
        }
    }

    private void setAuthors(ViewHolder holder, BookItem item) {
        VolumeInfo volumeInfo = item.getVolumeInfo();
        if (volumeInfo != null) {
            List<String> authorsList = volumeInfo.getAuthors();
            String authors = getAuthorList(authorsList);
            if (!Utils.isEmpty(authors)) {
                holder.authorsTextView.setText(authors);
            } else {
                holder.authorsLabelTextView.setVisibility(View.GONE);
            }
        }
    }

    private void setDate(ViewHolder holder, BookItem item) {
        VolumeInfo volumeInfo = item.getVolumeInfo();
            if (volumeInfo != null) {
            String date = volumeInfo.getPublishedDate();
            if (!Utils.isEmpty(date)) {
                holder.dateTextView.setText(date);
            } else {
                holder.dateLabelTextView.setVisibility(View.GONE);
            }
        }
    }

    private void setDescription(ViewHolder holder, BookItem item) {
        VolumeInfo volumeInfo = item.getVolumeInfo();
            if (volumeInfo != null) {
            String description = volumeInfo.getDescription();
            if (!Utils.isEmpty(description)) {
                holder.descriptionTextView.setText(description);
            } else {
                holder.descriptionLabelTextView.setVisibility(View.GONE);
            }
        }
    }

    private String getAuthorList(List<String> authorsList) {
        String authors = "";
        for (String item : authorsList) {
            authors = item + ",";
        }
        authors = authors.substring(0, authors.length() - 1);
        return authors;
    }

    //--------------------------------------------------
    // View Holder
    //--------------------------------------------------

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView pictureImageView;
        private TextView titleLabelTextView;
        private TextView titleTextView;
        private TextView authorsLabelTextView;
        private TextView authorsTextView;
        private TextView dateLabelTextView;
        private TextView dateTextView;
        private TextView descriptionLabelTextView;
        private TextView descriptionTextView;

        public ViewHolder(View view) {
            super(view);
            pictureImageView = (ImageView)view.findViewById(R.id.id_adapter_book__image_view);
            titleLabelTextView = (TextView)view.findViewById(R.id.id_adapter_book__title_label_text_view);
            titleTextView = (TextView)view.findViewById(R.id.id_adapter_book__title_text_view);
            authorsLabelTextView = (TextView)view.findViewById(R.id.id_adapter_book__authors_label_text_view);
            authorsTextView = (TextView)view.findViewById(R.id.id_adapter_book__authors_text_view);
            dateLabelTextView = (TextView)view.findViewById(R.id.id_adapter_book__date_label_text_view);
            dateTextView = (TextView)view.findViewById(R.id.id_adapter_book__date_text_view);
            descriptionLabelTextView = (TextView)view.findViewById(R.id.id_adapter_book__description_label_text_view);
            descriptionTextView = (TextView)view.findViewById(R.id.id_adapter_book__description_text_view);
        }
    }
}