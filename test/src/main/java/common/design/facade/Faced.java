package common.design.facade;

/**
 * 
 * 外观模式
 * 外观类对system类进行组装，暴露给客户端的为组装后的模式
 *
 */
class Faced {
	private SystemContent.SystemOne one;
	private SystemContent.SystemTwo two;
	private SystemContent.SystemThree three;
	Faced() {
		SystemContent system = new SystemContent();
		one = system.new SystemOne();
		two = system.new SystemTwo();
		three = system.new SystemThree();
	}
	void method1() {
		one.work();
		two.work();
	}
	void method2() {
		two.work();
		three.work();
	}
}
