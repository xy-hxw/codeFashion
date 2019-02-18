package common;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void testList() {
		List<String> list = new ArrayList<>();
		list.add("d");
		list.add("b");
		list.add("a");
		list.add("c");
		list.parallelStream().forEach(System.out::println);
		System.out.println();
		list.forEach(System.out::println);
		System.out.println();
		list.forEach(System.out::println);
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
			sb.append("str").append(i);
		}
		String str = "";
		for (int i = 0; i < 5; i++) {
			str = str + i;
		}
		
	}

	public static void test2() {
		String test2 = "public pointcut mostSpecificSubTypeConstruction() : if (thisJoinPoint.getSignature().getDeclaringType()==thisJoinPoint.getThis().getClass());";
		char[] chars_test2 = test2.toCharArray();
		for (int i = 0; i < chars_test2.length; i++) {
			String temp = String.valueOf(chars_test2[i]);
			// 判断是全角字符
			if (temp.matches("[^\\x00-\\xff]")) {
				System.out.println("全角   " + temp);
			}
			// 判断是半角字符
			else {
//				System.out.println("半角    " + temp);
			}
		}
	}

	public static void test3() {
		String.format("%s, appid(%d), tikcet(%s)", "abc".toString(), 0, "AAFcLGoDADAoAnuonKSFn5aBa1cIG_AIw9hd1_7Uf7SHLCVho-gyCWCcJD7U3u2q-dFa3uNFU9c");
	}
	public static void main(String[] args) {
		testList();
//		String property = System.getProperty("user.dir");
//		System.out.println(property);
//		testSplit();
//		test2();
//		test3();
	}
}
