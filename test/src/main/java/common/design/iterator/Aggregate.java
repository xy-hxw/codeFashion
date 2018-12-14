package common.design.iterator;

/**
 * @Author huoxianwei
 * @Date 2018/12/14 11:03
 * @Description 抽象聚集对象
 */
public abstract class Aggregate {
    // 创建外禀迭代子对象接口
    public abstract IteratorI createIterarorI();
    // 创建内禀迭代子对象接口
    public abstract IteratorI createInnerIterarorI();
}
