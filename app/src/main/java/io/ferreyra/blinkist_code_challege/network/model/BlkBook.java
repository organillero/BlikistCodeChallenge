package io.ferreyra.blinkist_code_challege.network.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

/**
 * Created by carlos on 10/29/17.
 */

@AutoValue
public abstract class BlkBook implements Parcelable {

    public static TypeAdapter<BlkBook> typeAdapter(Gson gson) {
        return new $AutoValue_BlkBook.GsonTypeAdapter(gson);
    }

    @SerializedName("id")
    public abstract String id();

    @SerializedName("etag")
    public abstract Long etag();

    @SerializedName("published_at")
    public abstract String publishedAt();

    @SerializedName("discoverable")
    public abstract boolean discoverable();

    @SerializedName("title")
    public abstract String title();

    @SerializedName("is_audio")
    public abstract boolean isAudio();

    @SerializedName("subtitle")
    public abstract String subtitle();

    @SerializedName("author")
    public abstract String author();

    @SerializedName("language")
    public abstract String language();

    @SerializedName("about_the_book")
    public abstract String aboutTheBook();

    @SerializedName("teaser")
    public abstract String teaser();

    @SerializedName("slug")
    public abstract String slug();

    @SerializedName("who_should_read")
    public abstract String whoShouldRead();

    @SerializedName("about_the_author")
    public abstract String aboutTheAuthor();

    @SerializedName("image_url")
    public abstract String imageURL();

    //todo
    //images

    @SerializedName("reading_duration")
    public abstract int readingDuration();

    @SerializedName("number_of_chapters")
    public abstract int numberOfChapters();

}
