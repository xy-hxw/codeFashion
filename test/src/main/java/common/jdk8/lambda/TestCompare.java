package common.jdk8.lambda;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author huoxianwei
 */
public class TestCompare {

	private static final int NUM = 5;

	/**
	 * 按map中的key或value排序
	 */
	private static void compareMap() {
		Map<Integer, Integer> map = new HashMap<>(10);
		for (int i = 0; i < NUM; i++) {
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
