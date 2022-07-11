package util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeStamp {
	private static final SimpleDateFormat dateTimeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public void getTimestamp() {
		Timestamp timestamp = new Timestamp();
	}
}
