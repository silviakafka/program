package time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CalendarTool {
	
	public static void main(String[] args) throws Exception
	{
		System.out.println(getMyDay("20150731",1));
	}

	public static String getMyDay(String myDate,int offset) throws Exception {
		

		int year = Integer.parseInt(myDate.substring(0, 4));
		int month = Integer.parseInt(myDate.substring(4, 6));
		int day = Integer.parseInt(myDate.substring(6,8));
		
		month=(month-1);
		year=year-1900;
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		Date date=new Date(year,month,day);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, offset);
		Date date1 = new Date(calendar.getTimeInMillis());
		return sf.format(date1);

	}


}
