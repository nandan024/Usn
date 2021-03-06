package com.param.usn.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.param.usn.R;

public class SchoolActivity extends AppCompatActivity {

    ImageButton Back = (ImageButton) findViewById(R.id.sBack);
    Button Savedetails = (Button) findViewById(R.id.sSavedetails);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SchoolActivity.this, UsnHomeActivity.class));
                finish();
            }
        });
        Savedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SchoolActivity.this, UsnHomeActivity.class));
                finish();
            }
        });
    }

}
