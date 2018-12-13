package common.design.observer;

/**
 * @Author huoxianwei
 * @Date 2018/12/13 18:25
 * @Description Test
 */
public class Test {
    public static void test() {
        // 观察者
        WatcherI user1 = new WatcherImpl("张三");
        WatcherI user2 = new WatcherImpl("李四");
        WatcherI user3 = new WatcherImpl("王五");
        // 对象
        ObserverableI observerableI = new ObserverableImpl();
        observerableI.registerObserver(user1);
        observerableI.registerObserver(user2);
        observerableI.registerObserver(user3);
        observerableI.setInformation("hello world");
        System.out.println(".................");
        observerableI.removeObserver(user2);
        observerableI.setInformation("李四辞职了");
    }

    public static void main(String[] args) {
        test();
    }
}
