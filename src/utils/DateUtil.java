package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getCurrentDate() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(new Date());
    }
}