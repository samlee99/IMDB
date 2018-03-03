package com.codingchallenge.samlee.imdb.movie;

import android.support.annotation.NonNull;

/**
 * Created by samlee on 3/2/18.
 */

public class MoviePresenter implements MovieContract.Presenter {

    private final MovieContract.View mMovieView;

    public MoviePresenter(@NonNull MovieContract.View movieView) {
        this.mMovieView = movieView;

        movieView.setPresenter(this);
    }

    @Override
    public void viewMovieDetailsClick() {

    }

    @Override
    public void refreshListClick() {

    }

    @Override
    public void start() {

    }
}
