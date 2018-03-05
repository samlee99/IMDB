package com.codingchallenge.samlee.imdb.movie;

import android.support.annotation.NonNull;

import com.codingchallenge.samlee.imdb.BasePresenter;
import com.codingchallenge.samlee.imdb.BaseView;
import com.codingchallenge.samlee.imdb.model.Movie;

import java.util.List;

/**
 * Created by samlee on 3/2/18.
 */

public interface MovieContract {

    interface View extends BaseView<Presenter> {
        void showMovieDetailsActivity(@NonNull Movie movie);
        void showMovieList();
        void showLoadingScreen();
        void refresh();

        boolean isActive();
    }

    interface Presenter extends BasePresenter<View> {
        void viewMovieDetailsClick(@NonNull Movie movie);
        void refreshListClick();
    }
}
