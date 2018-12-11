package common.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {
	/**
	 * 看反编译后文件
	 */
	public static void test1() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			sb.append("str"+i);
		}
		String str = "";
		for (int i = 0; i < 5; i++) {
			str = str + i;
		}
		System.out.println(str);
	}
	public static void test2() {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add("str"+i);
		}
		List<String> subList = list.subList(0, 2);
		subList.add("str");
		list.forEach(System.out::println);
	}
	/**
	 *  Arrays.asList 采用的适配器模式
	 *  返回的ArrayList指向的还是原String[]内存地址
	 *  谨慎修改
	 */
	public static void test3() {
		String[] str = new String[] {"you", "wu"}; 
		List<String> asList = Arrays.asList(str);
		asList.forEach(System.out::println);
	}
	// toArray方法
	// asList的返回对象是一个Arrays内部类，并没有实现集合的修改方法。
	// Arrays.asList体现的是适配器模式，只是转换接口，后台的数据仍是数组。
	public static void test4() {
		List<String> list = new ArrayList<>();
		list.add("a1");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		String[] array = list.toArray(new String[list.size()]);
		Arrays.asList(array).parallelStream().forEach(key->System.out.println(key));
	}
	// forEach循环中不能进行元素的remove/add操作
	// 使用Iterator对元素进行操作，如果是并发操作，需要加锁
	public static void test5() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
//		for(String str:list) {
//			if("a".equals(str)) {
//				list.remove(str);
//			}
//		}
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			if("a".equals(next)) {
				iterator.remove();
			}
		}
		list.parallelStream().forEach(key->System.out.println(key));
	}
	public static void main(String[] args) {
//		test1();
//		test2();
//		test3();
//		test4();
		test5();
	}
}
