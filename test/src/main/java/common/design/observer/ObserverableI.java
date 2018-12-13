package common.design.observer;

/**
 * @Author huoxianwei
 * @Date 2018/12/13 18:02
 * @Description 对象接口
 */
public interface ObserverableI {

    void registerObserver(WatcherI watcherI);
    void removeObserver(WatcherI watcherI);
    void notifyObserver();
    void setInformation(String information);
}
