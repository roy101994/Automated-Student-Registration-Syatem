package com.project.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public String checkDates(String start_date,String end_date)
	{
		String msg = null;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		ft.setLenient(false);
		try {
			Date dt1 = ft.parse(start_date);
			Date dt2 = ft.parse(end_date);
			
			Calendar sDate = Calendar.getInstance();
			Calendar eDate = Calendar.getInstance();
			Calendar currentDate = Calendar.getInstance();
			
			sDate.setTime(dt1);//here inputDate is date given by the user.
			eDate.setTime(dt2);//here inputDate is date given by the user.
			
			if(sDate.before(currentDate)) {
			    msg = "Start date is before current date(today)";
			}else if(eDate.before(sDate)) {
			    msg = "End date is before start date.";
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			msg = "Stick to specified date format.";
		} 
		return msg;	
	}
}
