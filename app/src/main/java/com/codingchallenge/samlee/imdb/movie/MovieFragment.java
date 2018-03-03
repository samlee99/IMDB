package com.codingchallenge.samlee.imdb.movie;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by samlee on 3/2/18.
 */

public class MovieFragment extends Fragment implements MovieContract.View {

    private MovieContract.Presenter mPresenter;

    private MovieAdapter mMovieAdapter;

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

    @Override
    public void setPresenter(MovieContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    public static class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

        private List<Object> movieList;


        @Override
        public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(MovieViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        public class MovieViewHolder extends RecyclerView.ViewHolder {
            private ImageView mMovieCoverImageView;
            private TextView mMovieTitleTextView, mMovieDetailTextView;

            public MovieViewHolder(View itemView) {
                super(itemView);

                mMovieCoverImageView = (ImageView) itemView.findViewById(R.id.movieCoverImageView);
                mMovieTitleTextView = (TextView) itemView.findViewById(R.id.movieTitleTextView);
                mMovieDetailTextView = (TextView) itemView.findViewById(R.id.movieDetailTextView);

            }
        }
    }
}
