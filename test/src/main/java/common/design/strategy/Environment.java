package common.design.strategy;

/**
 * @Author huoxianwei
 * @Date 2018/12/13 11:16
 * @Description 环境角色
 */
public class Environment {

    // 持有策略对象的引用
    private StrategyI strategyI;

    // 构造方法接受策略对象
    public Environment(StrategyI strategyI) {
        this.strategyI = strategyI;
    }

    // 调用策略对象的算法
    public int calculate(int i, int j) {
        return this.strategyI.calculate(i, j);
    }
}
