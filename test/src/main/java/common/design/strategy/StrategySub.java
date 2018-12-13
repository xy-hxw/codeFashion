package common.design.strategy;

/**
 * @Author huoxianwei
 * @Date 2018/12/13 11:13
 * @Description 具体策略角色  减法
 */
public class StrategySub implements StrategyI{

    @Override
    public int calculate(int i, int j) {
        return i - j;
    }
}
