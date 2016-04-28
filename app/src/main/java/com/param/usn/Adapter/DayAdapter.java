package com.param.usn.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.param.usn.DataObject.ScheduleDO;
import com.param.usn.R;
import com.param.usn.Utilities.CalendarUtils;
import com.param.usn.Utilities.StringUtils;

import java.util.ArrayList;

/**
 * Created by Aritra on 4/26/2016.
 */
public class DayAdapter extends RecyclerView.Adapter<DayAdapter.ViewHolder>  {

    private Context context;
    private ArrayList<ScheduleDO> arrCallDetails;

    public DayAdapter(Context context, ArrayList<ScheduleDO> arrCallDetails) {
        this.context=context;
        this.arrCallDetails = arrCallDetails;
    }

    public void refresh(ArrayList<ScheduleDO> arrCallDetails) {
        this.arrCallDetails = arrCallDetails;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_adapter_cell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final ScheduleDO objSMSDO = arrCallDetails.get(position);
        holder.tvScheduleName.setText(objSMSDO.ScheduleName);
        holder.tvScheduleTitle.setText(objSMSDO.ScheduleTitle);
        holder.tvScheduleTime.setText(objSMSDO.ScheduleTime);

        switch(StringUtils.getInt(objSMSDO.ScheduleType)){
            case 0 :
                holder.ivScheduleType.setBackgroundColor(context.getResources().getColor(R.color.colorPink));
                break;
            case 1:
                holder.ivScheduleType.setBackgroundColor(context.getResources().getColor(R.color.colorGreen));
                break;
            case 2 :
                holder.ivScheduleType.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
                break;
            case 3:
                holder.ivScheduleType.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
                break;
        }
    }

    @Override
    public int getItemCount() {
        if(arrCallDetails != null)
            return arrCallDetails.size();

        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView ivScheduleType;
        public final TextView tvScheduleName;
        public final TextView tvScheduleTitle;
        public final TextView tvScheduleTime;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivScheduleType      = (ImageView) view.findViewById(R.id.ivScheduleType);
            tvScheduleName      = (TextView) view.findViewById(R.id.tvScheduleName);
            tvScheduleTitle     = (TextView) view.findViewById(R.id.tvScheduleTitle);
            tvScheduleTime      = (TextView) view.findViewById(R.id.tvScheduleTime);
        }

        @Override
        public String toString() {
            return "";
        }
    }
}
