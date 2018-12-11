package common.classloader;

public final class FinalClass {
	private String str;
	public static String name;
	public void doSomething() {
		System.out.println(11);
	}
	public static void doSomething1() {
		System.out.println(22);
	}
	public static void main(String[] args) {
		FinalClass.doSomething1();
		FinalClass instance = new FinalClass();
		instance.doSomething();
	}
}
