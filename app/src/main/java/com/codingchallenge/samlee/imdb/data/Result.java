package com.codingchallenge.samlee.imdb.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Sam on 3/4/2018.
 */

public class Result implements Serializable {
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("about")
    @Expose
    private About about;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public About getAbout() {
        return about;
    }

    public void setAbout(About about) {
        this.about = about;
    }
}
