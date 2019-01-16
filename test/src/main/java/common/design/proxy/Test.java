package common.design.proxy;

/**
 * @author huoxianwei
 * @date 2019-01-16
 */
public class Test {
	/**
	 * 静态代理测试
	 */
	public static void test1() {
		IUserDao target = new UserDao();
		IUserDao proxy = new StaticProxy(target);
		proxy.save();
	}
	/**
	 * JDK动态代理测试
	 */
	private static void test2() {
		IUserDao target = new UserDao();
		System.out.println(target.getClass());
		IUserDao proxy = (IUserDao) new JdkProxy(target).getProxyInstance();
		System.out.println(proxy.getClass());
		proxy.save();
	}
	/**
	 * Cglib动态代理
 	 */
	private static void test3() {
		StudentDao target = new StudentDao();
		StudentDao proxy = (StudentDao) new CglibProxy(target).getProxyInstance();
		proxy.save();
	}
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
}
