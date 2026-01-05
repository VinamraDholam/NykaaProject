package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	 public static String getTimeStamp() {
	        return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
	    }

}
