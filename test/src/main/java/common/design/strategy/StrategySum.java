package common.design.strategy;

/**
 * @Author huoxianwei
 * @Date 2018/12/13 11:07
 * @Description 具体策略角色  加法
 */
public class StrategySum implements StrategyI{
    @Override
    public int calculate(int i, int j) {
        return i + j;
    }
}
