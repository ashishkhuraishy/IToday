package com.example.itoday;

import android.util.EventLogTags;

public class Details {

    //Declaring Variables

    private String mAuthor;
    private String mTitle;
    private String mDescription;
    private String mWebUrl;
    private String mImageUrl;
    private String mPublishedAt;
    private String mContent;

    //Setting Up the Object

    public Details(String author, String title, String description, String webUrl, String imageUrl, String publishedAt, String content) {
        mAuthor = author;
        mTitle = title;
        mDescription = description;
        mWebUrl = webUrl;
        mImageUrl = imageUrl;
        mPublishedAt =publishedAt;
        mContent = content;
    }

    //Setting up the Methods

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmWebUrl() {
        return mWebUrl;
    }

    public String getmPublishedAt() {
        return mPublishedAt;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmContent() {
        return mContent;
    }
}
