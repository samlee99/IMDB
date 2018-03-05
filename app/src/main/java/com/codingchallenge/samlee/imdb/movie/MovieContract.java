package com.codingchallenge.samlee.imdb.movie;

import android.support.annotation.NonNull;

import com.codingchallenge.samlee.imdb.BasePresenter;
import com.codingchallenge.samlee.imdb.BaseView;
import com.codingchallenge.samlee.imdb.data.Movie;

import java.util.List;

/**
 * Created by samlee on 3/2/18.
 */

public interface MovieContract {

    interface View extends BaseView<Presenter> {
        void showMovieDetailsActivity(@NonNull Movie movie);
        void showMovieList(List<Movie> movies);
        void showLoadingScreen();
        void refresh();
        void startLoader();
    }

    interface Presenter extends BasePresenter<View> {
        void viewMovieDetailsClick(@NonNull Movie movie);
        void refreshListClick();

        void start();
    }
}
