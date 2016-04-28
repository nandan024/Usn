package com.param.usn.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.param.usn.R;

/**
 * Created by Aritra on 4/26/2016.
 */
public class ForgotpasswordActivity extends BaseActivity {

    private RelativeLayout llForgetPassActivity;
    private ImageButton ibBack;
    private Button btnSubmitemail;

    @Override
    public void initialize() {
        llForgetPassActivity =	(RelativeLayout)inflater.inflate(R.layout.content_forgotpassword,null);
        llBody.addView(llForgetPassActivity, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        initialiseControls();

        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.ic_back_white);
        toggle.syncState();

        drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSubmitemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initialiseControls(){
        btnSubmitemail      = (Button) llForgetPassActivity.findViewById(R.id.fForgotpwdbtn);
    }
}
