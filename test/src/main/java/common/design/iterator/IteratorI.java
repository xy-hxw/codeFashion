package common.design.iterator;

/**
 * @Author huoxianwei
 * @Date 2018/12/14 10:56
 * @Description 迭代子接口
 */
public interface IteratorI {
    public void first();
    public Object next();
    public boolean isDone();
    public Object currentItem(int index);
}
