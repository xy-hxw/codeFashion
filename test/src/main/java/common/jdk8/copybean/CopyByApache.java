package common.jdk8.copybean;

import com.alibaba.fastjson.JSON;
import common.pojo.Order;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author huoxianwei
 * @date 2019/6/17 16:25
 */
public class CopyByApache {
    private static void copy () {
        Order order = new Order();
        order.setId(1);
        order.setName("测试1");
        Order order1 = new Order();
        try {
            BeanUtils.copyProperties(order1, order);
            System.out.println(JSON.toJSONString(order1));
            order.setDescription("描述1");
            PropertyUtils.copyProperties(order1, order);
            System.out.println(JSON.toJSONString(order1));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        copy();
    }
}
