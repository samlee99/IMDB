package com.codingchallenge.samlee.imdb.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sam on 3/4/2018.
 */

public class Data implements Serializable {
    @SerializedName("inTheaters")
    @Expose
    private List<InTheater> inTheaters = null;

    public List<InTheater> getInTheaters() {
        return inTheaters;
    }

    public void setInTheaters(List<InTheater> inTheaters) {
        this.inTheaters = inTheaters;
    }
}
