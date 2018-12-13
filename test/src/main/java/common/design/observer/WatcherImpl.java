package common.design.observer;

/**
 * @Author huoxianwei
 * @Date 2018/12/13 18:07
 * @Description 观察者
 */
public class WatcherImpl implements WatcherI{

    private String name;
    private String message;

    WatcherImpl(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    private void read() {
        System.out.println(name +" 收到消息："+message);
    }
}
