package common.design.flyweight;

/**
 * @Author huoxianwei
 * @Date 2018/12/12 16:22
 * @Description 单纯享元模式
 */
public class FlyWeightImpl implements FlyWeightI {

    private Character initState;

    public FlyWeightImpl(Character initState) {
        this.initState = initState;
    }

    @Override
    public void operation(String state) {
        System.out.println("内蕴状态="+this.initState);
        System.out.println("外蕴状态="+state);
    }
}
