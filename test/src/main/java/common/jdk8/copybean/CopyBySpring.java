package common.jdk8.copybean;

import common.pojo.Order;
import org.springframework.beans.BeanUtils;

/**
 * @author huoxianwei
 * @date 2019/6/14 9:38
 */
public class CopyBySpring {
    public static void copyBean () {
        Order order = new Order();
        order.setName("订单一");
        Order order1 = new Order();
        BeanUtils.copyProperties(order, order1);
        System.out.println(order1);
    }
    public static void main(String[] args) {
        copyBean();
    }
}
