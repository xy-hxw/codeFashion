package common.classloader;

public class ClassLoaderOrder extends ClassLoaderParent implements ClassLoader{
	private ClassLoaderOrder() {
		System.out.println("子类的构造方法");
	}
	public static String str = "子类静态常量";
	private final static String str1 = "final修饰静态常量";
	static {
		System.out.println("子类的静态块");
		System.out.println("子类静态块调用="+str);
		System.out.println("子类静态块调用="+str1);
	}
	{
		System.out.println("子类的代码块");
	}
	private void say1() {
		System.out.println("这是子类一个普通方法");
	}
	public static void say2() {
		System.out.println("这是子类一个静态方法");
	}
	public static void main(String[] args) {
//		say2();
		new ClassLoaderOrder().say1();
		System.out.println("---------------");
		new ClassLoaderOrder().say1();
	}
}
