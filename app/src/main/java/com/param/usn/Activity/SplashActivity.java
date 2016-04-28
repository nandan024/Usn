package com.param.usn.Activity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import com.param.usn.R;

/**
 * Created by Aritra on 4/26/2016.
 */
public class SplashActivity extends BaseActivity {

    private LinearLayout llSplashActivity;
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    public void initialize() {
        llSplashActivity =	(LinearLayout)inflater.inflate(R.layout.activity_splashscreen,null);
        llBody.addView(llSplashActivity, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        toolbar.setVisibility(View.GONE);
        navigationView.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
