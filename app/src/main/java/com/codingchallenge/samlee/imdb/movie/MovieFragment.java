package com.codingchallenge.samlee.imdb.movie;

import android.support.v4.app.Fragment;

/**
 * Created by samlee on 3/2/18.
 */

public class MovieFragment extends Fragment implements MovieContract.View {

    private MovieContract.Presenter mPresenter;

    public MovieFragment() {

    }

    public static MovieFragment newInstance() {
        return new MovieFragment();
    }

    @Override
    public void showMoviesList() {

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
