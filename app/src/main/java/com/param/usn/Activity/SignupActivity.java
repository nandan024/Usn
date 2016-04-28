package com.param.usn.Activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.param.usn.R;

/**
 * Created by Aritra on 4/26/2016.
 */
public class SignupActivity extends BaseActivity {

    private RelativeLayout llSignupActivity;
    private EditText edtUsername, edtPassword, edtMail;
    private Button btnSignup;
    private TextView tvSignin;

    @Override
    public void initialize() {
        llSignupActivity =	(RelativeLayout)inflater.inflate(R.layout.content_signup,null);
        llBody.addView(llSignupActivity, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        initialiseControls();

        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.ic_back_white);
        toggle.syncState();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edtMail.getText().toString())) {
                    edtMail.setError("Invalid EMail Address");
                    edtMail.requestFocus();
                } else if (!validatePassword(edtMail.getText().toString())) {
                    edtMail.setError("Invalid EMail Address");
                    edtMail.requestFocus();
                } else if (TextUtils.isEmpty(edtPassword.getText().toString())) {
                    edtPassword.setError("Invalid Password");
                    edtPassword.requestFocus();
                } else if (!validatePassword(edtPassword.getText().toString())) {
                    edtPassword.setError("Invalid Password");
                    edtPassword.requestFocus();
                } else {
                    finish();
                }
            }
        });
        tvSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initialiseControls(){
        edtUsername = (EditText) llSignupActivity.findViewById(R.id.etUsername);
        edtPassword = (EditText) llSignupActivity.findViewById(R.id.etPassword);
        edtMail = (EditText) llSignupActivity.findViewById(R.id.etMail);
        btnSignup = (Button) llSignupActivity.findViewById(R.id.etSignup);
        tvSignin = (TextView) llSignupActivity.findViewById(R.id.etSignin);
    }
}
