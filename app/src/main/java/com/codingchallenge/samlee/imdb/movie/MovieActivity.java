package com.codingchallenge.samlee.imdb.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import com.codingchallenge.samlee.imdb.R;

/**
 * Created by samlee on 3/2/18.
 */

public class MovieActivity extends AppCompatActivity {

    private MoviePresenter mMoviePresenter;
    private MovieFragment mMovieFragment;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mMovieFragment = (MovieFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (mMovieFragment == null) {
            //Create the fragment
            mMovieFragment = MovieFragment.newInstance();

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.contentFrame, mMovieFragment);
            fragmentTransaction.commit();
        }

        mMoviePresenter = new MoviePresenter(mMovieFragment);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.refresh_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                mMoviePresenter.refreshListClick();
                return true;
        }
        return true;
    }
}
