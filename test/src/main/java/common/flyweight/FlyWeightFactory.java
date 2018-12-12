package common.flyweight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author huoxianwei
 * @Date 2018/12/12 16:28
 * @Description 享元工厂
 */
public class FlyWeightFactory {
    private Map<Character, FlyWeightI> map = new HashMap<>();

    /**
     * 单纯享元工厂方法
     * @param state
     * @return
     */
    public FlyWeightI factory(Character state) {
        FlyWeightI flyWeightI = map.getOrDefault(state, new FlyWeightImpl(state));
        map.put(state, flyWeightI);
        return flyWeightI;
    }
    public FlyWeightI factory(List<Character> states) {
        FlyWeightComplex flyWeightI = new FlyWeightComplex();
        if (null != states) {
            states.parallelStream().forEach(key-> flyWeightI.add(key, this.factory(key)));
        }
        return flyWeightI;
    }
}
