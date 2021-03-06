package com.codingchallenge.samlee.imdb.moviedetail;

import com.codingchallenge.samlee.imdb.data.Movie;

/**
 * Created by Sam on 3/4/2018.
 */

public class MovieDetailPresenter implements MovieDetailContract.Presenter {

    private MovieDetailContract.View mMovieDetailView;
    private Movie movie;

    public MovieDetailPresenter(MovieDetailContract.View view, Movie movie) {
        this.mMovieDetailView = view;
        this.movie = movie;

        mMovieDetailView.setPresenter(this);
    }

    @Override
    public void start() {
        fillTextViews();
    }

    // Should I make these into separate methods or would this suffice for the presenter?
    private void fillTextViews() {
        String runtimeAndRated = (movie.getRuntime() == null ? "" : movie.getRuntime() + " | ") +
                (movie.getRated() == null ? "Not rated" : movie.getRated());
        String genres = movie.getGenres().toString().replace("[", "").replace("]","");
        String director = movie.getDirectors() == null ? "N/A" : movie.getDirectors().get(0).getName();
        String languages = (movie.getLanguages() == null || movie.getLanguages().size() < 1) ?
                "N/A" : movie.getLanguages().toString().replace("[","").replace("]","");

        mMovieDetailView.showMovieTitleToolbar(movie.getTitle());
        mMovieDetailView.showCoverImage(movie.getUrlPoster());
        mMovieDetailView.showRuntimeAndRated(runtimeAndRated);
        mMovieDetailView.showGenres(genres);
        mMovieDetailView.showDirector(director);
        mMovieDetailView.showLanguages(languages);
        mMovieDetailView.showPlot(movie.getPlot());
    }
}
