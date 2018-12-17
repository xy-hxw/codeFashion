package common.design.interpreter;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 18:10
 * @Description 终结表达式实现类
 */
public class MulNodeImpl extends SymbolNodeI {

    public MulNodeImpl(NodeI left, NodeI right) {
        super(left, right);
    }

    @Override
    public Integer interpret() {
        return left.interpret()*right.interpret();
    }
}
