package common.design.decorator;

/**
 * 装饰器模式
 */
public class Test {
	public static void main(String[] args) {
		Worker teacher = new TeacherImpl();
		Worker a = new Aworker(teacher);
		a.doSomething();
		Worker police = new PoliceImpl();
		Worker a1 = new Aworker(police);
		a1.doSomething();
	}
}
