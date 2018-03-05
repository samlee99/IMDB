package com.codingchallenge.samlee.imdb.moviedetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.codingchallenge.samlee.imdb.R;
import com.codingchallenge.samlee.imdb.data.Movie;

/**
 * Created by Sam on 3/4/2018.
 */

public class MovieDetailActivity extends AppCompatActivity {

    private MovieDetailPresenter mMovieDetailPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MovieDetailFragment movieDetailFragment = (MovieDetailFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (movieDetailFragment == null) {
            //Create the fragment
            movieDetailFragment = MovieDetailFragment.newInstance();

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.contentFrame, movieDetailFragment);
            fragmentTransaction.commit();
        }

        Movie movie = (Movie)getIntent().getSerializableExtra("movieObject");
        mMovieDetailPresenter = new MovieDetailPresenter(movieDetailFragment, movie);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
