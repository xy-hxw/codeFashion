package common.design.flyweight;

/**
 * @Author huoxianwei
 * @Date 2018/12/12 16:20
 * @Description 享元模式接口
 */
public interface FlyWeightI {
    // state为享元对象外蕴状态
    void operation(String state);
}
