package common.design.singleton;
/**
 * 静态内部类
 *
 */
public class Singleton3 {
	//私有化构造方法
	private Singleton3() {};
	//静态内部类创建对象
	private static class SingletonInstance {
		private static final Singleton3 instance = new Singleton3();
	}
	//对外提供对象的方法
	public static Singleton3 getInstance() {
		return SingletonInstance.instance;
	}
}
