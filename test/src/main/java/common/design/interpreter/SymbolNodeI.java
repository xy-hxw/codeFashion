package common.design.interpreter;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 18:07
 * @Description 终结表达式抽象类
 */
public abstract class SymbolNodeI implements NodeI {
    protected NodeI left;
    protected NodeI right;

    public SymbolNodeI(NodeI left, NodeI right) {
        this.left = left;
        this.right = right;
    }
}
