package com.param.usn.Activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.param.usn.Adapter.DayAdapter;
import com.param.usn.DataObject.ScheduleDO;
import com.param.usn.R;

import java.util.ArrayList;

/**
 * Created by Aritra on 4/28/2016.
 */
public class WeekActivity extends BaseActivity {

    private LinearLayout llWeekActivity;
    private CollapsingToolbarLayout toolbar_layout;
    //private WeekCalendar weekCalendar;
    private RecyclerView rvSchedule;
    private DayAdapter adapter;
    private ArrayList<ScheduleDO> arrCallDetails;

    @Override
    public void initialize() {
        llWeekActivity =	(LinearLayout)inflater.inflate(R.layout.content_week,null);
        llBody.addView(llWeekActivity, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        initialseControls();

        bindControls();
    }

    private void bindControls() {
        /*weekCalendar.setOnDateClickListener(new OnDateClickListener() {
            @Override
            public void onDateClick(DateTime dateTime) {
                Toast.makeText(WeekActivity.this, "You Selected " + dateTime.toString(), Toast
                        .LENGTH_SHORT).show();
            }
        });*/

        arrCallDetails = new ArrayList<>();

        ScheduleDO objScheduleDO  = new ScheduleDO();
        objScheduleDO.ScheduleName = "CS 101";
        objScheduleDO.ScheduleTitle = "HomeWork Assignment Due";
        objScheduleDO.ScheduleTime = "8 - 10 AM";
        objScheduleDO.ScheduleType = "0";
        arrCallDetails.add(objScheduleDO);

        objScheduleDO  = new ScheduleDO();
        objScheduleDO.ScheduleName = "Kinkos";
        objScheduleDO.ScheduleTitle = "Work on Creating Portfolios";
        objScheduleDO.ScheduleTime = "10 - 12 PM";
        objScheduleDO.ScheduleType = "1";
        arrCallDetails.add(objScheduleDO);

        objScheduleDO  = new ScheduleDO();
        objScheduleDO.ScheduleName = "Mc D";
        objScheduleDO.ScheduleTitle = "Lunch with Tom";
        objScheduleDO.ScheduleTime = "12 - 1 AM";
        objScheduleDO.ScheduleType = "2";
        arrCallDetails.add(objScheduleDO);

        objScheduleDO  = new ScheduleDO();
        objScheduleDO.ScheduleName = "Kinkos";
        objScheduleDO.ScheduleTitle = "Complete Portfolio project";
        objScheduleDO.ScheduleTime = "2 - 4 PM";
        objScheduleDO.ScheduleType = "3";
        arrCallDetails.add(objScheduleDO);

        objScheduleDO  = new ScheduleDO();
        objScheduleDO.ScheduleName = "EE 101";
        objScheduleDO.ScheduleTitle = "Engineering Dept";
        objScheduleDO.ScheduleTime = "5 - 6 PM";
        objScheduleDO.ScheduleType = "0";
        arrCallDetails.add(objScheduleDO);

        adapter.refresh(arrCallDetails);
    }

    private void initialseControls(){
        //weekCalendar        = (WeekCalendar) llWeekActivity.findViewById(R.id.weekCalendar);
        rvSchedule          = (RecyclerView) llWeekActivity.findViewById(R.id.rvSchedule);
        rvSchedule.setLayoutManager(new LinearLayoutManager(this));
        toolbar_layout      = (CollapsingToolbarLayout) llWeekActivity.findViewById(R.id.toolbar_layout);

        adapter             = new DayAdapter(WeekActivity.this,new ArrayList<ScheduleDO>());
        rvSchedule.setAdapter(adapter);
    }
}
