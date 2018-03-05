package com.codingchallenge.samlee.imdb.moviedetail;

import com.codingchallenge.samlee.imdb.BasePresenter;
import com.codingchallenge.samlee.imdb.BaseView;

/**
 * Created by samlee on 3/2/18.
 */

public interface MovieDetailContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter<View> {

    }
}
