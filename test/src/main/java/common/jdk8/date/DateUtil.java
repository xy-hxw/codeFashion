package common.jdk8.date;

import java.time.Instant;
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
    private static LocalDateTime ldtByDate(Date date) {
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
    private static Date dateByLdt(LocalDateTime localDateTime) {
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

    /**
     * 获取某天最小时间 2019-01-24 00:00:00
     * 支持jdk1.8+
     * @param date 日期
     * @return date
     */
    private static Date getStartOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获得某天最大时间 2017-10-15 23:59:59
     */
    private static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
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
        Date startOfDay = getStartOfDay(new Date());
        System.out.println(startOfDay);
        Date endOfDay = getEndOfDay(new Date());
        System.out.println(endOfDay);
    }
}
