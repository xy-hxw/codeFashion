package common.jdk8.date;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Objects;

/**
 * @author huoxianwei
 * @date 2019/6/3 9:42
 */
public class DateUtil {

    /**
     * date 转换成 localDateTime
     * @param date date
     * @return localDateTime
     */
    public static LocalDateTime ldtByDate(Date date) {
        if (Objects.isNull(date)) {
            date = new Date();
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * localDateTime 转成date
     * @param localDateTime 转成date
     * @return localDateTime
     */
    public static Date dateByLdt (LocalDateTime localDateTime) {
        if (Objects.isNull(localDateTime)) {
            localDateTime = LocalDateTime.now();
        }
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取当前月第一天
     * @param date date
     * @return Date
     */
    public static Date firstDayOfMonth (Date date) {
        return firstDayOfMonth(ldtByDate(date));
    }

    /**
     * 获取当前月第一天
     * @param localDateTime localDateTime
     * @return Date
     */
    private static Date firstDayOfMonth (LocalDateTime localDateTime) {
        if (null == localDateTime) {
            localDateTime = LocalDateTime.now();
        }
        LocalDateTime start = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
        return Date.from(start.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取当前月最后一天
      * @param date date
     * @return Date
     */
    public static Date lastDayOfMonth (Date date) {
        return lastDayOfMonth(ldtByDate(date));
    }

    /**
     * 获取当前月最后一天
     * @param localDateTime localDateTime
     * @return Date
     */
    private static Date lastDayOfMonth (LocalDateTime localDateTime) {
        if (null == localDateTime) {
            localDateTime = LocalDateTime.now();
        }
        LocalDateTime end = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
        return Date.from(end.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static void main(String[] args) {
        Date date = new Date();
        LocalDateTime localDateTime = ldtByDate(date);
        System.out.println(localDateTime);
        Date date1 = dateByLdt(localDateTime);
        System.out.println(date1);
        Date date2 = firstDayOfMonth(date);
        Date date3 = firstDayOfMonth(localDateTime);
        Date date4 = lastDayOfMonth(date);
        Date date5 = lastDayOfMonth(localDateTime);
        System.out.println(date2);
        System.out.println(date3);
        System.out.println(date4);
        System.out.println(date5);
    }
}
