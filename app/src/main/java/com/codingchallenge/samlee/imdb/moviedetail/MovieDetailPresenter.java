package com.codingchallenge.samlee.imdb.moviedetail;

/**
 * Created by Sam on 3/4/2018.
 */

public class MovieDetailPresenter implements MovieDetailContract.Presenter {

    private MovieDetailContract.View mMovieDetailView;

    public MovieDetailPresenter(MovieDetailContract.View view) {
        this.mMovieDetailView = view;
    }

    @Override
    public void start() {

    }
}
