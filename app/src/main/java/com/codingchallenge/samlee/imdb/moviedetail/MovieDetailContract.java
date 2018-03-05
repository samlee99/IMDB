package com.codingchallenge.samlee.imdb.moviedetail;

import com.codingchallenge.samlee.imdb.BasePresenter;
import com.codingchallenge.samlee.imdb.BaseView;

/**
 * Created by samlee on 3/2/18.
 */

public interface MovieDetailContract {

    interface View extends BaseView<Presenter> {
        void showMovieTitleToolbar(String movieTitle);
        void showCoverImage(String url);
        void showRuntimeAndRated(String runtimeAndRated);
        void showGenres(String genres);
        void showDirector(String director);
        void showLanguages(String languages);
        void showPlot(String plot);
    }

    interface Presenter extends BasePresenter<View> {

    }
}
