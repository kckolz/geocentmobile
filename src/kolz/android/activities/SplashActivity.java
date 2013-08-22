package kolz.android.activities;

import kolz.android.MainActivity;
import kolz.android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

public class SplashActivity extends Activity {

	private static final String TAG = "SplashActivity";
	private final long SPLASH_DISPLAY_LENGTH = 3000;

	public void onCreate(Bundle icicle) {

		super.onCreate(icicle);
		setContentView(R.layout.splash);

		/*
		 * New Handler to start the Menu-Activity and close this Splash-Screen
		 * after some seconds.
		 */
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				/* Create an Intent that will start the Menu-Activity. */
				Intent mainIntent = new Intent(SplashActivity.this,
						MainActivity.class);
				startActivity(mainIntent);
				finish();
			}
		}, SPLASH_DISPLAY_LENGTH);
	}
}
