package common.design.iterator;

/**
 * @Author huoxianwei
 * @Date 2018/12/14 11:05
 * @Description 具体角色聚集类
 */
public class ConcreteAggregateImpl extends Aggregate {

    private Object[] objArray = null;

    // 构造方法  传入聚合对象具体内容
    public ConcreteAggregateImpl(Object[] objArray) {
        this.objArray = objArray;
    }
    // 创建内禀迭代子对象
    @Override
    public IteratorI createIterarorI() {
        return new ConcreteIteratorImpl(this);
    }
    // 创建内禀迭代子对象
    @Override
    public IteratorI createInnerIterarorI() {
        return new InnerIteratorImpl();
    }

    // 向外提供取值方法
    public Object getElement(int index) {
        if (index < objArray.length) {
            return objArray[index];
        }
        return null;
    }
    // 提供聚集的大小
    public int size() {
        return objArray.length;
    }

    // 内部类 内禀迭代子
    private class InnerIteratorImpl implements IteratorI {
        private int index = 0;
        private int size = 0;

        public InnerIteratorImpl() {
            this.size = objArray.length;
            index = 0;
        }

        @Override
        public void first() {
            index = 0;
        }

        @Override
        public Object next() {
            Object object = null;
            if (index < size) {
                object = currentItem(index);
                index++;
            }
            return object;
        }

        @Override
        public boolean isDone() {
            return index >= size;
        }

        @Override
        public Object currentItem(int index) {
            return objArray[index];
        }
    }
}