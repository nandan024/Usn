package com.param.usn.Activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.param.usn.Adapter.DayAdapter;
import com.param.usn.DataObject.ScheduleDO;
import com.param.usn.R;
import com.param.usn.Utilities.CalendarUtils;

import java.util.ArrayList;

/**
 * Created by Aritra on 4/26/2016.
 */
public class DayActivity extends BaseActivity {

    private LinearLayout llDayActivity;
    private FloatingActionButton fabNewSchedule;
    private RecyclerView rvSchedule;
    private TextView tvDate;
    private DayAdapter adapter;
    private ArrayList<ScheduleDO> arrCallDetails;

    @Override
    public void initialize() {
        llDayActivity =	(LinearLayout)inflater.inflate(R.layout.activity_day,null);
        llBody.addView(llDayActivity, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        initialseControls();

        tvDate.setText(CalendarUtils.getCommaFormattedDate(CalendarUtils.getCurrentDateTime()));

        binndControls();
    }

    private void binndControls(){
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
        fabNewSchedule      = (FloatingActionButton) llDayActivity.findViewById(R.id.fabNewSchedule);
        rvSchedule          = (RecyclerView) llDayActivity.findViewById(R.id.rvSchedule);
        tvDate              = (TextView) llDayActivity.findViewById(R.id.tvDate);

        adapter = new DayAdapter(DayActivity.this,new ArrayList<ScheduleDO>());
        rvSchedule.setAdapter(adapter);
    }
}
