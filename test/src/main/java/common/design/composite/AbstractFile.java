package common.design.composite;

/**
 * @Author huoxianwei
 * @Date 2018/12/11 17:22
 */
abstract class AbstractFile {
    public void add(AbstractFile file) {
        System.out.println("对不起，不支持该方法");
    }
    public void delete(AbstractFile file) {
        System.out.println("对不起，不支持该方法");
    }
    public AbstractFile getChild(int i) {
        System.out.println("对不起，不支持该方法");
        return null;
    }
    public abstract void killVirus();
}