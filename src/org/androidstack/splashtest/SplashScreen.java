package org.androidstack.splashtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {
	 
    private static final int SPLASH_DISPLAY_TIME = 2000;  /* 2 seconds */

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splash);
           
             /* Create a new handler with which to start the main activity
                and close this splash activity after SPLASH_DISPLAY_TIME has
                elapsed. */
            new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                           
                            /* Create an intent that will start the main activity. */
                            Intent mainIntent = new Intent(SplashScreen.this,
                                    MainApp.class);
                            SplashScreen.this.startActivity(mainIntent);
                           
                            /* Finish splash activity so user cant go back to it. */
                            SplashScreen.this.finish();
                           
                            /* Apply our splash exit (fade out) and main
                               entry (fade in) animation transitions. */
                            overridePendingTransition(R.anim.mainfadein,
                                    R.anim.splashfadeout);
                    }
            }, SPLASH_DISPLAY_TIME);
    }
}