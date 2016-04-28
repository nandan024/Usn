package com.param.usn.CustomUtils.CustomWeekView.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;

import com.param.usn.CustomUtils.CustomWeekView.fragment.WeekFragment;
import com.param.usn.R;

import org.joda.time.DateTime;

import static com.param.usn.CustomUtils.CustomWeekView.fragment.WeekFragment.DATE_KEY;
import static com.param.usn.CustomUtils.CustomWeekView.view.WeekPager.NUM_OF_PAGES;

/**
 * Created by nor on 12/4/2015.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = "PagerAdapter";
    private int currentPage = NUM_OF_PAGES / 2;
    private DateTime date;
    private TypedArray typedArray;
    private Context context;

    public PagerAdapter(Context context, FragmentManager fm, DateTime date, TypedArray typedArray) {
        super(fm);
        this.date = date;
        this.typedArray = typedArray;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        WeekFragment fragment = new WeekFragment();
        Bundle bundle = new Bundle();

        if (position < currentPage)
            bundle.putSerializable(DATE_KEY, getPerviousDate());
        else if (position > currentPage)
            bundle.putSerializable(DATE_KEY, getNextDate());
        else
            bundle.putSerializable(DATE_KEY, getTodaysDate());

        bundle.putFloat(WeekFragment.TEXT_SIZE_KEY, typedArray.getDimension(R.styleable
                .WeekCalendar_daysTextSize, -1));
        bundle.putInt(WeekFragment.TEXT_COLOR_KEY, typedArray.getColor(R.styleable
                .WeekCalendar_daysTextColor, Color.BLACK));
        bundle.putInt(WeekFragment.TODAYS_DATE_COLOR_KEY, typedArray.getColor(R.styleable
                .WeekCalendar_todaysDateBgColor, ContextCompat.getColor(context, R.color
                .colorAccent)));
        bundle.putInt(WeekFragment.SELECTED_DATE_COLOR_KEY, typedArray.getColor(R.styleable
                .WeekCalendar_selectedBgColor, ContextCompat.getColor(context, R.color
                .colorAccent)));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return NUM_OF_PAGES;
    }

    private DateTime getTodaysDate() {
        return date;
    }

    private DateTime getPerviousDate() {
        return date.plusDays(-7);
    }

    private DateTime getNextDate() {
        return date.plusDays(7);
    }

    public void swipeBack() {
        date = date.plusDays(-7);
        currentPage--;
        currentPage = currentPage <= 1 ? NUM_OF_PAGES / 2 : currentPage;
    }


    public void swipeForward() {
        date = date.plusDays(7);
        currentPage++;
        currentPage = currentPage >= NUM_OF_PAGES - 1 ? NUM_OF_PAGES / 2 : currentPage;
    }
}
