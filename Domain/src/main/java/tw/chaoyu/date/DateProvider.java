package tw.chaoyu.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class DateProvider {
    private static Date now;

    public static void setNow(Calendar now) {
        DateProvider.now = now.getTime();
    }

    public static Date now() {
        return now == null ? new Date() : now;
    }
}
