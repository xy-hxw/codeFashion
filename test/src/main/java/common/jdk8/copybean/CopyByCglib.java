package common.jdk8.copybean;

import common.pojo.Order;
import org.springframework.cglib.beans.BeanCopier;

/**
 * @author huoxianwei
 * @date 2019/6/14 10:11
 */
public class CopyByCglib {
    public static void copy (Object source, Object target) {
        BeanCopier beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
        beanCopier.copy(source, target, null);
    }
    public static void copyBean () {
        Order order = new Order();
        order.setName("订单一");
        Order order1 = new Order();
        copy(order, order1);
        System.out.println(order1);
    }
    public static void main(String[] args) {
        copyBean();
    }
}
