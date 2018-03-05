package com.codingchallenge.samlee.imdb.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Sam on 3/4/2018.
 */

public class About implements Serializable {

    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("serverTime")
    @Expose
    private String serverTime;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }
}
