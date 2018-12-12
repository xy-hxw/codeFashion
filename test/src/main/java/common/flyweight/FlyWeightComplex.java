package common.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huoxianwei
 * @Date 2018/12/12 16:44
 * @Description 复合享元
 */
public class FlyWeightComplex implements FlyWeightI{
    private Map<Character, FlyWeightI> map = new HashMap<>();

    /**
     * 增加一个享元对象到聚集中
     * @param key
     * @param value
     */
    public void add(Character key, FlyWeightI value) {
        map.put(key, value);
    }

    /**
     * 外蕴状态作为参数传入到方法中
     * @param state
     */
    @Override
    public void operation(String state) {
        if (null != map) {
            map.forEach((key, value)-> value.operation(state));
        }
    }
}
