package com.codingchallenge.samlee.imdb.utils;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.codingchallenge.samlee.imdb.data.InTheater;
import com.codingchallenge.samlee.imdb.data.Movie;
import com.codingchallenge.samlee.imdb.data.Result;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam on 3/4/2018.
 */

public class JsonAsyncTaskLoader extends AsyncTaskLoader<List<Movie>> {

    private static final String TAG = "JsonAsyncTaskLoader";

    private List<Movie> movies;

    public JsonAsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        Log.d(TAG, "onStartLoading() called");
        if (movies != null) {
            deliverResult(movies);
        } else {
            forceLoad();
        }
    }

    @Override
    public List<Movie> loadInBackground() {
        Log.d(TAG, "loadInBackground() called");
        movies = new ArrayList<>();

        String url = "http://api.myapifilms.com/imdb/inTheaters?token=159ab6ca-37ea-4351-ba42-9ef903beacc3&format=json&language=en-us";

        HttpRequest httpRequest = HttpRequest.get(url);
        String json = httpRequest.body();

        Gson gson = new Gson();
        Result result = gson.fromJson(json, Result.class);

        if (result != null && result.getData() != null) {
            List<InTheater> inTheaterList = result.getData().getInTheaters();
            for (InTheater theater : inTheaterList) {
                movies.addAll(theater.getMovies());
            }
        }

        return movies;
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
    }

    @Override
    public void deliverResult(List<Movie> data) {
        Log.d(TAG, "deliverResult called");
        movies = data;
        super.deliverResult(data);
    }
}
