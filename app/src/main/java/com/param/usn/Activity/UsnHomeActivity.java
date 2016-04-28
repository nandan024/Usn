package com.param.usn.Activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.param.usn.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aritra on 4/26/2016.
 */
public class UsnHomeActivity extends BaseActivity {

    private CoordinatorLayout llUsnHomeActivity;
    private CollapsingToolbarLayout toolbar_layout;
    private CalendarView cvMonth;
    private TextView tvDay,tvWeek,tvMonth;


    @Override
    public void initialize() {
        llUsnHomeActivity =	(CoordinatorLayout)inflater.inflate(R.layout.activity_usnhome,null);
        llBody.addView(llUsnHomeActivity, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        initialiseControls();

        tvDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UsnHomeActivity.this, DayActivity.class));
            }
        });
        tvWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UsnHomeActivity.this, WeekActivity.class));
            }
        });
        toolbar_layout.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        cvMonth.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Snackbar.make(view, dayOfMonth+"/"+month+"/"+year, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        cvMonth.setShowWeekNumber(false);
        cvMonth.setFirstDayOfWeek(2);
        //cvMonth.setBackgroundColor(getResources().getColor(R.color.colorgrey));
        //cvMonth.setDateTextAppearance(getResources().getColor(R.color.colorgrey));

        final List<String> mutableBookings = new ArrayList<>();

        final ListView bookingsListView = (ListView) findViewById(R.id.bookings_listview);

        final ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mutableBookings);
        bookingsListView.setAdapter(adapter);
    }

    private void initialiseControls(){
        cvMonth                 = (CalendarView) llUsnHomeActivity.findViewById(R.id.cvMonth);
        toolbar_layout          = (CollapsingToolbarLayout) llUsnHomeActivity.findViewById(R.id.toolbar_layout);
        tvDay                   = (TextView) llUsnHomeActivity.findViewById(R.id.tvDay);
        tvWeek                  = (TextView) llUsnHomeActivity.findViewById(R.id.tvWeek);
        tvMonth                 = (TextView) llUsnHomeActivity.findViewById(R.id.tvMonth);
    }
}