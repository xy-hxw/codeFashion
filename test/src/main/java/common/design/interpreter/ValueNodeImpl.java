package common.design.interpreter;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 18:04
 * @Description 非终结表达式
 */
public class ValueNodeImpl implements NodeI {
    private int value;

    public ValueNodeImpl(int value) {
        this.value = value;
    }

    @Override
    public Integer interpret() {
        return this.value;
    }
}
