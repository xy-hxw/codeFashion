package common.design.proxy;

public class Test {
	/**
	 * 静态代理测试
	 */
	public static void test1() {
		IUserDao target = new UserDao();
		IUserDao proxy = new StaticProxy(target);
		proxy.save();
	}
	// JDK动态代理测试
	public static void test2() {
		IUserDao target = new UserDao();
		System.out.println(target.getClass());
		IUserDao proxy = (IUserDao) new JDKProxy(target).getProxyInstance();
		System.out.println(proxy.getClass());
		proxy.save();
	}
	// Cglib动态代理
	public static void test3() {
		StudentDao target = new StudentDao();
		StudentDao proxy = (StudentDao) new CglibProxy(target).getProxyInstance();
		proxy.save();
	}
	public static void main(String[] args) {
//		test1();
//		test2();
		test3();
	}
}
