package com.codingchallenge.samlee.imdb.movie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingchallenge.samlee.imdb.R;

import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

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

        private List<Object> mMovieList;
        private LayoutInflater mInflater;

        public MovieAdapter(@NonNull Context context, List<Object> movies) {
            this.mMovieList = movies;
            this.mInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.list_item_movies, parent, false);
            return new MovieViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MovieViewHolder holder, int position) {
            // TODO: Initialize all the movie photos, titles, details, and onclicks.

        }

        @Override
        public int getItemCount() {
            return mMovieList.size();
        }

        public class MovieViewHolder extends RecyclerView.ViewHolder {
            private ImageView mMovieCoverImageView;
            private TextView mMovieTitleTextView, mMovieDetailTextView, mViewDetailsButtonTextView;

            public MovieViewHolder(View itemView) {
                super(itemView);

                mMovieCoverImageView = (ImageView) itemView.findViewById(R.id.movieCoverImageView);
                mMovieTitleTextView = (TextView) itemView.findViewById(R.id.movieTitleTextView);
                mMovieDetailTextView = (TextView) itemView.findViewById(R.id.movieDetailTextView);
                mViewDetailsButtonTextView = (TextView) itemView.findViewById(R.id.viewDetailsButtonTextView);
            }
        }
    }
}
