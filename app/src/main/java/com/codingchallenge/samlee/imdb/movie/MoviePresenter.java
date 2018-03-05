package com.codingchallenge.samlee.imdb.movie;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.codingchallenge.samlee.imdb.model.Movie;
import com.codingchallenge.samlee.imdb.utils.JsonAsyncTaskLoader;

import java.util.List;

/**
 * Created by samlee on 3/2/18.
 */

public class MoviePresenter implements MovieContract.Presenter{

    private final MovieContract.View mMovieView;

    public MoviePresenter(@NonNull MovieContract.View movieView) {
        this.mMovieView = movieView;

        movieView.setPresenter(this);
    }

    @Override
    public void viewMovieDetailsClick(@NonNull Movie movie) {
        mMovieView.showMovieDetailsActivity(movie);
    }

    @Override
    public void refreshListClick() {
        mMovieView.refresh();
    }

    @Override
    public void start() {
        mMovieView.startLoader();
    }


}
