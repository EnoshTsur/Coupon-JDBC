package utils;

import java.sql.Date;

public class DateUtils {

	public static Date fixDate(String date) {
		Date finalDate = Date.valueOf(date);
		return finalDate;
	}

}
