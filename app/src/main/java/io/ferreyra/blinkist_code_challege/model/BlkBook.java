package io.ferreyra.blinkist_code_challege.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;


/**
 * Created by carlos on 10/29/17.
 */

@Entity
public  class BlkBook{

    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    @NonNull
    private  String id;

    @SerializedName("etag")
    private  Long etag;

    @SerializedName("published_at")
    private DateTime publishedAt;

    @SerializedName("discoverable")
    private  boolean discoverable;

    @SerializedName("title")
    private  String title;

    @SerializedName("is_audio")
    private  boolean isAudio;

    @SerializedName("subtitle")
    public  String subtitle;

    @SerializedName("author")
    private  String author;

    @SerializedName("language")
    private  String language;

    @SerializedName("about_the_book")
    private  String aboutTheBook;

    @SerializedName("teaser")
    private  String teaser;

    @SerializedName("slug")
    private  String slug;

    @SerializedName("who_should_read")
    private  String whoShouldRead;

    @SerializedName("about_the_author")
    private  String aboutTheAuthor;

    @SerializedName("image_url")
    private  String imageURL;

    //todo
    //images

    @SerializedName("reading_duration")
    private int readingDuration;

    @SerializedName("number_of_chapters")
    private int numberOfChapters;


    /*
    * GETTERS AND SETTERS
    * */

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public Long getEtag() {
        return etag;
    }

    public void setEtag(Long etag) {
        this.etag = etag;
    }

    public DateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(DateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public boolean isDiscoverable() {
        return discoverable;
    }

    public void setDiscoverable(boolean discoverable) {
        this.discoverable = discoverable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAudio() {
        return isAudio;
    }

    public void setAudio(boolean audio) {
        isAudio = audio;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAboutTheBook() {
        return aboutTheBook;
    }

    public void setAboutTheBook(String aboutTheBook) {
        this.aboutTheBook = aboutTheBook;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getWhoShouldRead() {
        return whoShouldRead;
    }

    public void setWhoShouldRead(String whoShouldRead) {
        this.whoShouldRead = whoShouldRead;
    }

    public String getAboutTheAuthor() {
        return aboutTheAuthor;
    }

    public void setAboutTheAuthor(String aboutTheAuthor) {
        this.aboutTheAuthor = aboutTheAuthor;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getReadingDuration() {
        return readingDuration;
    }

    public void setReadingDuration(int readingDuration) {
        this.readingDuration = readingDuration;
    }

    public int getNumberOfChapters() {
        return numberOfChapters;
    }

    public void setNumberOfChapters(int numberOfChapters) {
        this.numberOfChapters = numberOfChapters;
    }
}
