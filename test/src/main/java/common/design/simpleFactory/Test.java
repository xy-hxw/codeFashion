package common.design.simpleFactory;

public class Test {
	public static void main(String[] args) {
		Factory factory = new CarFactory();
		Product create = factory.create();
		factory.create();
		create.load();
	}
}
