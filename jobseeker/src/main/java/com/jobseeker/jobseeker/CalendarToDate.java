package com.jobseeker.jobseeker;

import java.util.*;

public class CalendarToDate {
    public CalendarToDate()
    {

    }

    public String dateConversionToSQLDate(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return Integer.toString(year) +'-'+Integer.toString(month)+'-'+Integer.toString(day);

    }
}
