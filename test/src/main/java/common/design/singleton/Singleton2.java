package common.design.singleton;

/**
 * 懒汉式
 *双重非空校验，避免多个线程同时进来第一个判断，产生多个实例
 */
public class Singleton2 {
	//声明静态私有变量
	private static Singleton2 singleton;
	//私有化构造方法
	private Singleton2() {};
	//声明静态方法返回实例
	public static Singleton2 getInstance() {
		if(null == singleton) {
			synchronized(Singleton2.class) {
				if(null == singleton) {
					singleton = new Singleton2();
				}
			}
		}
		return singleton;
	}
}
