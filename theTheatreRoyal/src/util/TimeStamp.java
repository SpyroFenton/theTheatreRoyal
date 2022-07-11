package util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeStamp {
	private static final SimpleDateFormat dateTimeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	// prints out timestamp
	public static void printTimestamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(dateTimeStamp.format(timestamp));
	}
	
	// this method may not be needed
	public static String getTimestamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return dateTimeStamp.format(timestamp);
	}
	
}
