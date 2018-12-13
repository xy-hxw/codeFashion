package common.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huoxianwei
 * @Date 2018/12/13 18:04
 * @Description 对象具体实现
 */
public class ObserverableImpl implements ObserverableI {

    // 存储观察者
    private List<WatcherI> list = new ArrayList<>();
    // 消息储存
    private String message;

    @Override
    public void registerObserver(WatcherI watcherI) {
        list.add(watcherI);
    }

    @Override
    public void removeObserver(WatcherI watcherI) {
        if (null != list) {
            list.remove(watcherI);
        }
    }

    @Override
    public void notifyObserver() {
        if (null != list) {
            list.parallelStream().forEach(key -> key.update(message));
        }
    }

    @Override
    public void setInformation(String information) {
        this.message = information;
        System.out.println("服务器更新消息="+information);
        notifyObserver();
    }
}
