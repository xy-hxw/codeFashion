package common.design.iterator;

/**
 * @Author huoxianwei
 * @Date 2018/12/14 10:59
 * @Description ConcreteIteratorImpl
 */
public class ConcreteIteratorImpl implements IteratorI{

    // 持有被迭代的具体对象
    private ConcreteAggregateImpl concreteAggregate;
    // 记录当前迭代到的索引位置
    private int index = 0;
    // 记录当前聚集对象的大小
    private int size = 0;

    public ConcreteIteratorImpl(ConcreteAggregateImpl concreteAggregate) {
        this.concreteAggregate = concreteAggregate;
        this.index = 0;
        this.size = concreteAggregate.size();
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public Object next() {
        Object obj = null;
        if (index < size) {
            obj = currentItem(index);
            index++;
        }
        return obj;
    }

    @Override
    public boolean isDone() {
        return index >= size;
    }

    @Override
    public Object currentItem(int index) {
        return concreteAggregate.getElement(index);
    }
}
