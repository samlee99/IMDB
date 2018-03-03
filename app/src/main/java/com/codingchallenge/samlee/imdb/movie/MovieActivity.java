package com.codingchallenge.samlee.imdb.movie;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.codingchallenge.samlee.imdb.R;

/**
 * Created by samlee on 3/2/18.
 */

public class MovieActivity extends AppCompatActivity {

    private MoviePresenter mMoviePresenter;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MovieFragment movieFragment = (MovieFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (movieFragment == null) {
            //Create the fragment
            movieFragment = MovieFragment.newInstance();

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.contentFrame, movieFragment);
            fragmentTransaction.commit();
        }

        mMoviePresenter = new MoviePresenter(movieFragment);

        // TODO: Load saved state if available
    }

    // TODO: Save state when changing orientation
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
                // TODO: Implement the refresh functionality where it calls the API to refresh the recyclerview.  Should not break during orientation change.
                Toast.makeText(this, "Refresh testing!", Toast.LENGTH_SHORT).show();
                return true;
        }
        return true;
    }
}
