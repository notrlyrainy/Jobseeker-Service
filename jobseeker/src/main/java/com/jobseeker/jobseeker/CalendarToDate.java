package com.jobseeker.jobseeker;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.StringTokenizer;
//import java.util.Calendar;

public class CalendarToDate {
    public CalendarToDate()
    {

    }

    public String zonedDateTimeToSQLString(ZonedDateTime date)
    {
        //Calendar calendar = Calendar.getInstance();
        //calendar.setTime(date);
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        return Integer.toString(year) +'-'+Integer.toString(month)+'-'+Integer.toString(day);

    }

    public ZonedDateTime SQLToZonedDateTime(Date sqlDate)
    {
        String date = sqlDate.toString();
        StringTokenizer st = new StringTokenizer(date, "-");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        ZonedDateTime zonedDateTime = ZonedDateTime.of(year, month, day, 0, 0, 0, 0, ZoneId.of("UTC"));
        return zonedDateTime;
    }
}
