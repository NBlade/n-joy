package com.mygdx.game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;

public class Play extends Activity {
    private final DisplayMetrics mMetrics = new DisplayMetrics();
    private float mScreenDensity;
    private GameView mGameView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context mContext = getApplicationContext();

        /**
         * Get the screen density that all pixel values will be based on.
         * This allows scaling of pixel values over different screen sizes.
         *
         * See: http://developer.android.com/reference/android/util/DisplayMetrics.html
         */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
        mScreenDensity = mMetrics.density;

        /**
         * There is only one map in this example.
         * In a real game, the user's chosen level should be
         * passed to this activity.
         */
        int level = 1;

        Log.d(Constants.N_JOY, "Starting game at level: " + level);
        mGameView = new GameView(mContext, this, level, mScreenDensity);

        setContentView(mGameView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;

        switch (item.getItemId()) {
            case R.id.menuAbout:
                i = new Intent(this, About.class);
                startActivity(i);
                return true;
            case R.id.menuExit:
                finish();
                return true;
        }

        return false;
    }

    /**
     * Invoked when the Activity loses user focus.
     */
    @Override
    protected void onPause() {
        super.onPause();

        mGameView.getThread().setState(GameView.STATE_PAUSED); // pause game when Activity pauses
    }
}