package common.design.facade;

/**
 * 外观模式
 */
public class Test {
	public static void main(String[] args) {
		Faced faced = new Faced();
		faced.method1();
		java.lang.System.out.println("----");
		faced.method2();
	}
}
