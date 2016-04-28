package com.param.usn.Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Aritra on 4/26/2016.
 */
public class CalendarUtils {
    private static final String DATETIME_FORMAT_WITH_COMMA = "dd MMM, yyyy\nhh:mm:ss aa";
    private static final String DATE_FORMAT_WITH_COMMA = "MMM dd, yyyy";
    private static final String DATE_TIME_FORMAT = "dd-MM-yyyy'T'HH:mm:ss";

    public static String getCommaFormattedDateTime(String dateTime) {
        String reqDate = "";

        Calendar calendar = Calendar.getInstance();

        if (dateTime.contains("T")){
            String date = dateTime.split("T")[0];
            String str[] = date.split("-");

            calendar.set(Calendar.DAY_OF_MONTH,StringUtils.getInt(str[0]));
            calendar.set(Calendar.MONTH,StringUtils.getInt(str[1]) - 1);
            calendar.set(Calendar.YEAR,StringUtils.getInt(str[2]));

            String time = dateTime.split("T")[1];
            String strTime[] = time.split(":");
            calendar.set(Calendar.HOUR_OF_DAY,StringUtils.getInt(strTime[0]));
            calendar.set(Calendar.MINUTE,StringUtils.getInt(strTime[1]));
            calendar.set(Calendar.SECOND,StringUtils.getInt(strTime[2]));
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_FORMAT_WITH_COMMA);
        reqDate = simpleDateFormat.format(calendar.getTime());

        return reqDate;
    }

    public static String getCommaFormattedDate(String dateTime) {
        String reqDate = "";

        Calendar calendar = Calendar.getInstance();

        if (dateTime.contains("T")){
            String date = dateTime.split("T")[0];
            String str[] = date.split("-");

            calendar.set(Calendar.DAY_OF_MONTH,StringUtils.getInt(str[0]));
            calendar.set(Calendar.MONTH,StringUtils.getInt(str[1]) - 1);
            calendar.set(Calendar.YEAR,StringUtils.getInt(str[2]));
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_WITH_COMMA);
        reqDate = simpleDateFormat.format(calendar.getTime());

        return reqDate;
    }

    public static String getCurrentDateTime() {
        String reqDate = "";

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
        reqDate = simpleDateFormat.format(calendar.getTime());

        return reqDate;
    }

    public static String getDateTime(String date) {
        String reqDate = "";

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(StringUtils.getLong(date));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
        reqDate = simpleDateFormat.format(calendar.getTime());

        return reqDate;
    }

    public static int getDiffBtwDatesInMinutes(String startDate,String endDate)
    {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        calendar1.setTime(CalendarUtils.getDateFromString(startDate, CalendarUtils.DATE_TIME_FORMAT));
        calendar2.setTime(CalendarUtils.getDateFromString(endDate, CalendarUtils.DATE_TIME_FORMAT));

        long milliseconds1 = calendar1.getTimeInMillis();
        long milliseconds2 = calendar2.getTimeInMillis();

        long diff = milliseconds2 - milliseconds1;
        int diffMins = (int) (diff / (60 * 1000));

        return diffMins;
    }

    public static Date getDateFromString(String date, String pattern)
    {
        Date dateObj = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try
        {
            dateObj = sdf.parse(date);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return dateObj;
    }
}
