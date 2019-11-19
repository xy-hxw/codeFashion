package test;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	private static void jsonTest() {
		Map<String, Object> extension_map = new HashMap<>();
		extension_map.put("master", "邀请人");
		extension_map.put("open_id", "用户公众号标识");
		extension_map.put("union_id", "用户应用标识");
		
		/**
		 * 上传图片
		 */
		List<Map<String, String>> picture_list = new ArrayList<Map<String, String>>();
		for (int i = 0; i < 3; i++) {
			Map<String, String> slave_map = new HashMap<>();
			slave_map.put("score", "分值");
			slave_map.put("picture_url", "上传图片的url");
			picture_list.add(slave_map);
		}
		
		/**
		 * 答题
		 */
		Map<String, String> answer_map = new HashMap<>();
		answer_map.put("key1", "答案1");
		answer_map.put("key2", "答案2");
		
		extension_map.put("picture", picture_list);
		extension_map.put("answer", answer_map);
		
		Gson gson = new Gson(); 
		String json = gson.toJson(extension_map);
		System.out.println(json);
	}
	public static void main(String[] args) {
		String str = "oR5GjjgEhCMJFyzaVZdrxZ2zRRF4";
		System.out.println(str.length());
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(currentTimeMillis);
		jsonTest();
	}
}
