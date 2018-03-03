package com.codingchallenge.samlee.imdb.movie;

import com.codingchallenge.samlee.imdb.BasePresenter;
import com.codingchallenge.samlee.imdb.BaseView;

/**
 * Created by samlee on 3/2/18.
 */

public interface MovieContract {

    interface View extends BaseView<Presenter> {
        void showMoviesList();

        boolean isActive();
    }

    interface Presenter extends BasePresenter<View> {
        void viewMovieDetailsClick();
        void refreshListClick();
    }
}
