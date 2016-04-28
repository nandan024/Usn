package com.param.usn.Activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.param.usn.DataObject.UserDO;
import com.param.usn.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aritra on 4/26/2016.
 */
public class LoginActivity extends BaseActivity {

    private RelativeLayout llLoginActivity;
    private EditText edtUsername, edtPassword;
    private Button btnSignin;
    private TextView tvForgotpassword, tvSignup;

    @Override
    public void initialize() {
        llLoginActivity =	(RelativeLayout)inflater.inflate(R.layout.content_login,null);
        llBody.addView(llLoginActivity, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        initialiseControls();
        toolbar.setVisibility(View.GONE);
        navigationView.setVisibility(View.GONE);

        btnSignin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(edtUsername.getText().toString())) {
                    edtUsername.setError("Invalid Email");
                    edtUsername.requestFocus();
                } else if(!validateEmail(edtUsername.getText().toString())) {
                    edtUsername.setError("Invalid Email");
                    edtUsername.requestFocus();
                } else if(TextUtils.isEmpty(edtPassword.getText().toString())) {
                    edtPassword.setError("Invalid Password");
                    edtPassword.requestFocus();
                } else if (!validatePassword(edtPassword.getText().toString())) {
                    edtPassword.setError("Invalid Password");
                    edtPassword.requestFocus();
                } else {
                    UserDO userDO = new UserDO();
                    userDO.userName = edtUsername.getText().toString();
                    userDO.passWord = edtPassword.getText().toString();
                    Intent intent = new Intent(LoginActivity.this, UsnHomeActivity.class);
                    intent.putExtra("userDetail",userDO);
                    startActivity(intent);
                }
            }
        });
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });
        tvForgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotpasswordActivity.class));
            }
        });
    }

    private void initialiseControls(){
        edtUsername             = (EditText) llLoginActivity.findViewById(R.id.ibUsername);
        edtPassword             = (EditText) llLoginActivity.findViewById(R.id.ibPassword);

        btnSignin               = (Button) llLoginActivity.findViewById(R.id.ibSignin);

        tvForgotpassword        = (TextView) llLoginActivity.findViewById(R.id.ibForgotpwd);
        tvSignup                = (TextView) llLoginActivity.findViewById(R.id.ibSignup);
    }
}
