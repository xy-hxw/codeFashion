package common.lambda;

import java.util.*;

import com.alibaba.fastjson.JSON;

public class Test {
	/**
	 * 按map中的key或value排序
	 */
	private static void compareMap() {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			map.put(i, new Random().nextInt(10));
		}
		System.out.println(JSON.toJSONString(map));
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort(Comparator.comparing(Map.Entry<Integer, Integer>::getValue));
		System.out.println(JSON.toJSONString(list));
		list.sort(Comparator.comparing(Map.Entry<Integer, Integer>::getKey));
		System.out.println(JSON.toJSONString(list));
	}
	public static void main(String[] args) {
		compareMap();
	}
}
