package tw.chaoyu.date;

import java.time.LocalDate;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class DateProvider {
    private static LocalDate now;

    public static void setNow(LocalDate now) {
        DateProvider.now = now;
    }

    public static void setNow(int year, int month, int day) {
        DateProvider.now = LocalDate.of(year, month, day);
    }

    public static LocalDate now() {
        return now == null ? LocalDate.now() : now;
    }

}
