package com.codingchallenge.samlee.imdb.movie;

import android.support.annotation.NonNull;

import com.codingchallenge.samlee.imdb.data.Movie;

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
