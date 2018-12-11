package common.design.adaptor;

public class Test {
	/**
	 * 类适配器
	 */
	public static void test1() {
		Ps2 p = new Adaptor1();
		p.isPs2();
	}
	/**
	 * 类适配器
	 */
	public static void test2() {
		Ps2 p = new Adaptor2(new Usber());
		p.isPs2();
	}
	/**
	 * 接口适配器
	 */
	public static void test3() {
		A a = new Worker();
		a.a();
		a.e();
	}
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
}
