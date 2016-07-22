package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateCalulator {
	
	public int getCurrentMonth() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("mm");
		int returnMonth = calendar.get((Calendar.MONTH)) + 1;
		return returnMonth;
	}
	
	public int getCurrentYear() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("mm");
		int returnYear = calendar.get((Calendar.YEAR));
		return returnYear;
	}

	public int getLastDay(String documentYear, String documentMonth) {
		String docuYear = documentYear;
		String docuMonth = null;
		int lastDay = 0;
		if (documentMonth.length() == 1) {
			docuMonth = "0" + documentMonth;
		} else {
			docuMonth = documentMonth;
		}
		
		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymm");
			String strDate = docuYear + docuMonth;
			lastDay = calendar.getMaximum(Calendar.DAY_OF_MONTH);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lastDay;
	}
	
	public List<String> getDayofMonthList(String documentYear, String documentMonth, List<String> monthDay) {
		String docuYear = documentYear;
		String docuMonth = null;
		if (documentMonth.length() == 1) {
			docuMonth = "0" + documentMonth;
		} else {
			docuMonth = documentMonth;
		}

		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymm");
			String strDate = docuYear + docuMonth;
			int lastDay = calendar.getMaximum(Calendar.DAY_OF_MONTH);

			for (int i = 1; i <= lastDay; i++) {
				String strTemp = null;
				if (i < 10) {
					strTemp = "0" + String.valueOf(i);
				} else {
					strTemp = String.valueOf(i);
				}
				monthDay.add(strDate + strTemp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return monthDay;
	}
}
