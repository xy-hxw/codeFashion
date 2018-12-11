package common.classloader;

public interface ClassLoader {
	public void inter();
	default void inter1() {
		System.out.println("这是接口的【default】方法");
	};
	static void inter2() {
		System.out.println("这是接口的【static】方法");
	};
	
}
