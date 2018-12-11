package common.classloader;

public class ClassLoaderParent implements ClassLoader{
	public static String str = "abc";
	static {
		System.out.println("父类的静态块");
		System.out.println("父类的静态块调用静态参数"+str);
	}
	public static void say() {
		System.out.println("父类的静态方法");
	}
	@Override
	public void inter() {
		System.out.println("父类声明的的静态参数"+str);
		System.out.println("父类重写接口的方法");
	}
	ClassLoaderParent(){
		System.out.println("父类的构造方法");
	}
	{
		System.out.println("父类的代码块1");
	}
}
