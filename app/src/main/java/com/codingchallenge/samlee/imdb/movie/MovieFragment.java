package com.codingchallenge.samlee.imdb.movie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.codingchallenge.samlee.imdb.R;
import com.codingchallenge.samlee.imdb.data.Movie;
import com.codingchallenge.samlee.imdb.moviedetail.MovieDetailActivity;
import com.codingchallenge.samlee.imdb.utils.JsonAsyncTaskLoader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samlee on 3/2/18.
 */

public class MovieFragment extends Fragment implements MovieContract.View, LoaderManager.LoaderCallbacks<List<Movie>> {

    private static final String TAG = "MovieFragment";

    private MovieContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;

    private MovieAdapter mMovieAdapter;

    private ProgressBar mProgressBar;

    private boolean isLoaderRestarting = false;

    private static int id = 20;

    private MovieItemListener mMovieItemListener = new MovieItemListener() {
        @Override
        public void onViewDetailClick(Movie movie) {
            mPresenter.viewMovieDetailsClick(movie);
        }
    };

    public MovieFragment() {

    }

    public static MovieFragment newInstance() {
        return new MovieFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movie, container, false);

        mProgressBar = root.findViewById(R.id.loading_spinner);

        mRecyclerView = root.findViewById(R.id.movieRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);

        mMovieAdapter = new MovieAdapter(new ArrayList<Movie>(), mMovieItemListener);
        mRecyclerView.setAdapter(mMovieAdapter);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.start();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void showLoadingScreen() {
        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showMovieDetailsActivity(@NonNull Movie movie) {
        Intent intent = new Intent(getContext(), MovieDetailActivity.class);
        intent.putExtra("movieObject", movie);
        startActivity(intent);
    }

    @Override
    public void showMovieList(List<Movie> movies) {
        mMovieAdapter.setData(movies);

        mProgressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void startLoader() {
        getActivity().getSupportLoaderManager().initLoader(id, null, this);
    }

    @Override
    public void refresh() {
        if (!isLoaderRestarting) {
            getActivity().getSupportLoaderManager().restartLoader(id, null, this);
            isLoaderRestarting = true;
        }
    }

    @Override
    public void setPresenter(MovieContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public Loader<List<Movie>> onCreateLoader(int id, Bundle args) {
        Log.d(TAG, "onCreateLoader called");
        showLoadingScreen();
        return new JsonAsyncTaskLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<Movie>> loader, List<Movie> data) {
        Log.d(TAG, "onLoadFinished called");
        showMovieList(data);
        if (isLoaderRestarting) {
            isLoaderRestarting = false;
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Movie>> loader) {
        Log.d(TAG, "onLoaderReset called");
        mMovieAdapter = null;
        mRecyclerView.setAdapter(null);
    }

    public static class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

        private List<Movie> mMovieList;

        private MovieItemListener mItemListener;

        public MovieAdapter(List<Movie> movies, MovieItemListener listener) {
            this.mMovieList = movies;
            this.mItemListener = listener;
        }

        @Override
        public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movies, parent, false);
            return new MovieViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MovieViewHolder holder, int position) {
            final Movie movie = mMovieList.get(position);

            Picasso.with(holder.mMovieCoverImageView.getContext()).load(movie.getUrlPoster()).fit().into(holder.mMovieCoverImageView);
            holder.mMovieTitleTextView.setText(movie.getTitle());

            String rated = movie.getRated();
            String runtime = movie.getRuntime();
            String genre = movie.getGenres().get(0);
            String ratedRuntimeAndGenreString = (rated == null ? "Not Rated" : rated) + " | " + (runtime == null ? genre : runtime + " | " + genre);
            holder.mMovieDetailTextView.setText(ratedRuntimeAndGenreString);

            holder.mViewDetailsTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start moviedetail activity with passed in parameter of movie selected.
                    mItemListener.onViewDetailClick(movie);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mMovieList.size();
        }

        public void setData(List<Movie> movies) {
            this.mMovieList = movies;
            notifyDataSetChanged();
        }

        public class MovieViewHolder extends RecyclerView.ViewHolder {
            private ImageView mMovieCoverImageView;
            private TextView mMovieTitleTextView, mMovieDetailTextView, mViewDetailsTextView;

            public MovieViewHolder(View itemView) {
                super(itemView);

                mMovieCoverImageView = itemView.findViewById(R.id.movieCoverImageView);
                mMovieTitleTextView = itemView.findViewById(R.id.movieTitleTextView);
                mMovieDetailTextView = itemView.findViewById(R.id.movieDetailTextView);
                mViewDetailsTextView = itemView.findViewById(R.id.viewDetailsTextView);
            }
        }
    }

    public interface MovieItemListener {
        void onViewDetailClick(Movie movie);
    }
}
