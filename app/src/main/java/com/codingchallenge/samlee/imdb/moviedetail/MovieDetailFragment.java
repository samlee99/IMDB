package com.codingchallenge.samlee.imdb.moviedetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingchallenge.samlee.imdb.R;
import com.codingchallenge.samlee.imdb.model.Movie;
import com.codingchallenge.samlee.imdb.utils.ConvertUtil;
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

        Movie movie = (Movie)getActivity().getIntent().getSerializableExtra("movieObject");

        String runtimeAndRated = (movie.getRuntime() == null ? "" : ConvertUtil.convertMinutesToHrMin(movie.getRuntime()) + " | ") +
                (movie.getRated() == null ? "Not rated" : movie.getRated());

        String genres = movie.getGenres().toString().replace("[", "").replace("]","");
        String directors = movie.getDirectors() == null ? "N/A" : movie.getDirectors().get(0).getName();
        String languages = (movie.getLanguages() == null || movie.getLanguages().size() < 1) ?
                "N/A" : movie.getLanguages().toString().replace("[","").replace("]","");

        Picasso.with(getContext()).load(movie.getUrlPoster()).fit().into(mMovieCoverImageView);
        mMovieRuntimeAndRatedTextView.setText(runtimeAndRated);
        mMovieGenreTextView.setText(genres);
        mMovieDirectorTextView.setText(directors);
        mMovieLanguageTextView.setText(languages);
        mMoviePlotTextView.setText(movie.getPlot());

        return root;
    }
}
