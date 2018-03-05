package com.codingchallenge.samlee.imdb.moviedetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingchallenge.samlee.imdb.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Sam on 3/4/2018.
 */

public class MovieDetailFragment extends Fragment implements MovieDetailContract.View {

    private MovieDetailContract.Presenter mPresenter;

    private ImageView mMovieCoverImageView;

    private TextView mMovieRuntimeAndRatedTextView, mMovieGenreTextView, mMovieDirectorTextView, mMovieLanguageTextView, mMoviePlotTextView;

    public MovieDetailFragment() {

    }

    public static MovieDetailFragment newInstance() {
        return new MovieDetailFragment();
    }

    public void setPresenter(MovieDetailContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movie_detail, container, false);

        mMovieCoverImageView = root.findViewById(R.id.movieCoverImageView);
        mMovieRuntimeAndRatedTextView = root.findViewById(R.id.movieRuntimeAndRatedTextView);
        mMovieGenreTextView = root.findViewById(R.id.movieGenreTextView);
        mMovieDirectorTextView = root.findViewById(R.id.movieDirectorTextView);
        mMovieLanguageTextView = root.findViewById(R.id.movieLanguageTextView);
        mMoviePlotTextView = root.findViewById(R.id.moviePlotTextView);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void showMovieTitleToolbar(String movieTitle) {
        AppCompatActivity activity = (AppCompatActivity)getActivity();
        if (activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().setTitle(movieTitle);
        }
    }

    @Override
    public void showCoverImage(String url) {
        Picasso.with(getContext()).load(url).fit().into(mMovieCoverImageView);
    }

    @Override
    public void showRuntimeAndRated(String runtimeAndRated) {
        mMovieRuntimeAndRatedTextView.setText(runtimeAndRated);
    }

    @Override
    public void showGenres(String genres) {
        mMovieGenreTextView.setText(genres);
    }

    @Override
    public void showDirector(String director) {
        mMovieDirectorTextView.setText(director);
    }

    @Override
    public void showLanguages(String languages) {
        mMovieLanguageTextView.setText(languages);
    }

    @Override
    public void showPlot(String plot) {
        mMoviePlotTextView.setText(plot);
    }
}
