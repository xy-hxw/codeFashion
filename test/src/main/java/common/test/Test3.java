package common.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2019/1/31 12:22
 */
public class Test3 {

    public static void test () {
        List<String> list = new ArrayList<>(10);
        list.set(1, "a");
        list.forEach(System.out::println);
    }

    private static void testDate () {
        LocalDate today = LocalDate.now();
        //本月的第一天
        LocalDate firstday = LocalDate.of(today.getYear(),today.getMonth(),1);
        //本月的最后一天
        LocalDate lastDay =today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("本月的第一天"+firstday);
        System.out.println("本月的最后一天"+lastDay);
        LocalTime now = LocalTime.now();
        System.out.println(now);
        String str = firstday.toString()+" 00:00:00";
        String str1 = lastDay.toString()+" 23:59:59";
        System.out.println(str);
        System.out.println(str1);
    }

    private static void testBigDecimal () {
        BigDecimal bigDecimal = new BigDecimal("1.256");
        boolean b = bigDecimal.compareTo(BigDecimal.ZERO) == 0;
        System.out.println(b);
        System.out.println(bigDecimal.divide(new BigDecimal("-1")));
    }

    public static void main(String[] args) {
//        testDate();
        testBigDecimal();
    }
}
