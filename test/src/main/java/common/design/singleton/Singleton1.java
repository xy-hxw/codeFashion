package common.design.singleton;

/**
 * 恶汉式
 *优点：写法简单；类装载的时候实例化，避免了线程同步的问题
 *缺点：如果一直未使用这个实例，会造成内存浪费
 */
public class Singleton1 {
	//私有化对象
	private final static Singleton1 instance = new Singleton1();
	//私有化构造对象
	private Singleton1() {};
	//静态方法对外提供对象
	public static Singleton1 getInstance() {
		return instance;
	}
}
