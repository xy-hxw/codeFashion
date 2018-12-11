package common;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class Test {
	public static void testList() {
		List<String> list = new ArrayList<String>();
		list.add("d");
		list.add("b");
		list.add("a");
		list.add("c");
		list.parallelStream().forEach(key->System.out.print(key));
		System.out.println();
		list.stream().forEach(key->System.out.print(key));
		System.out.println();
		list.forEach(key->System.out.print(key));
		System.out.println();
		list.forEach(System.out::print);
	}
	public static void testSplit() {
		String str = "a,b,c,d,,";
		String[] split = str.split(",");
		System.out.println(JSON.toJSONString(split));
	}
	/**
	 * 看反编译后文件
	 */
	public void test1() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			sb.append("str"+i);
		}
		String str = "";
		for (int i = 0; i < 5; i++) {
			str = str + i;
		}
		
	}
	public static void main(String[] args) {
		//testList();
		String property = System.getProperty("user.dir");
		System.out.println(property);
		testSplit();
	}
}
