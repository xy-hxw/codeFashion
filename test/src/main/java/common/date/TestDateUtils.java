package common.date;

import com.alibaba.fastjson.JSON;
import common.pojo.Product;
import org.apache.commons.lang3.time.DateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author huoxianwei
 * @date 2019/2/28 19:27
 */
public class TestDateUtils {

    public static void test1 () {
        Date date = new Date();
        Date date1 = new Date();
        System.out.println(date.getTime());
        System.out.println(date1.getTime());
        System.out.println("两个Date日期是否相同="+DateUtils.isSameDay(date, date1));
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance1 = Calendar.getInstance();
        instance.setTime(date1);
        System.out.println("两个Calendar日期是否相同="+DateUtils.isSameDay(instance, instance1));
        System.out.println("两个Date日期-DateUtils.isSameInstant="+DateUtils.isSameInstant(date, date1));
        System.out.println("两个Calendar日期-DateUtils.isSameInstant="+DateUtils.isSameInstant(instance, instance1));
        System.out.println(instance.getTime().getTime());
        System.out.println(instance1.getTime().getTime());
        System.out.println("-----------------");
        LocalDate localDate = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate);
        LocalDate of = LocalDate.of(2019, 5, 8);
        long until = localDate.until(of, ChronoUnit.MONTHS);
        long until1 = of.until(localDate, ChronoUnit.MONTHS);
        System.out.println(until);
        System.out.println(until1);
//        System.out.println(DateUtils.isSameLocalTime());
    }

    public static void test2 () {
        List<Product> list = new ArrayList<>(3);
        Product product = new Product();
        product.setName("aaa");
        product.setPrice(1);
        Product product1 = new Product();
        product1.setName("bbb");
        product1.setPrice(5);
        Product product2 = new Product();
        product2.setName("ccc");
        product2.setPrice(8);
        list.add(product);
        list.add(product1);
        list.add(product2);
        Optional<Integer> reduce = list.parallelStream().map(Product::getPrice).reduce(Integer::sum);
        if (reduce.isPresent()) {
            Integer integer = reduce.get();
            System.out.println(integer);
        }
        List<Product> collect = list.parallelStream().filter(product3 -> product3.getPrice() > 6).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
    }

    public static void main(String[] args) {
//        test1();
//        test2();
//        List<ProductDetail> list = Lists.newArrayList();
//        for (int i = 0; i < 5; i++) {
//            ProductDetail product = new ProductDetail();
//            product.setPrice(i);
//            product.setName("name-"+i);
//            product.setDate(DateUtils.addDays(new Date(), -i));
//            list.add(product);
//        }
//        System.out.println(JSON.toJSONString(list));
//        Optional<ProductDetail> max = list.stream().filter(product -> product.getPrice() > 2).max(Comparator.comparing(ProductDetail::getDate));
//        if (max.isPresent()) {
//            System.out.println(max.get());
//        }
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        calendar2.set(Calendar.HOUR_OF_DAY, 0);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);
        calendar2.add(Calendar.DAY_OF_MONTH,1);
        System.out.println(calendar2.getTime());
    }
}
