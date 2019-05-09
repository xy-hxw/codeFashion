package common.jdk8.method;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author huoxianwei
 * @date 2019/2/13 15:27
 */
public class Test {
    public static void test1 () {
        int a = -7;
        int b = 4;
        int i = Math.floorDiv(a, b);
        System.out.println(i);
        System.out.println(a/b);
        int i1 = Math.floorMod(a, b);
        System.out.println(i1);
        System.out.println(a%b);
    }

    public static void test2 () {
        String string = "2019-01-31";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = DateUtils.addMonths(sdf.parse(string), 1);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void test3 () {
        LocalDateTime with = LocalDateTime.now().with(LocalTime.MAX);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(with);
        System.out.println(format);
    }


    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }
}
