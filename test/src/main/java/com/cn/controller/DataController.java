package com.cn.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataController {
	public static List<String> timeList() {
		List<String> list = new ArrayList<>();
//		Date date = new Date();
//	    Calendar calendar = Calendar.getInstance();
//	    calendar.setTime(date);
//	    SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:dd");
//	    for (int i = 0; i < 25; i++) {
//	    	list.add(format.format(calendar.getTime()));
//	    	calendar.add(Calendar.DATE, 1);
//		}
		list.add("18-10-17 16:17");
		list.add("18-10-18 16:18");
		list.add("18-10-19 16:19");
		list.add("18-10-20 16:20");
		list.add("18-10-21 16:21");
		list.add("18-10-22 16:22");
		list.add("18-10-23 16:23");
		list.add("18-10-24 16:24");
		list.add("18-10-25 16:25");
		list.add("18-10-26 16:26");
		list.add("18-10-27 16:27");
		list.add("18-10-28 16:28");
		list.add("18-10-29 16:29");
		list.add("18-10-30 16:30");
		list.add("18-10-31 16:31");
		list.add("18-11-01 16:01");
		list.add("18-11-02 16:02");
		list.add("18-11-03 16:03");
		list.add("18-11-04 16:04");
		list.add("18-11-05 16:05");
		list.add("18-11-06 16:06");
		list.add("18-11-07 16:07");
		list.add("18-11-08 16:08");
		list.add("18-11-09 16:09");
		list.add("18-11-10 16:10");
	    return list;
	}
	public static List<List<String>> numList() {
		List<List<String>> list = new ArrayList<>();
		for (int i = 0; i < 125; i++) {
			List<String> temp = new ArrayList<>();
			temp.add((i+1)+"");
			temp.add("检查项目"+i);
			list.add(temp);
		}
		return list;
	}
	public static List<Map<String, String>> dataList() {
		List<Map<String, String>> list = new ArrayList<>();
		List<String> timeList = timeList();
		for (int i = 0; i < 125; i++) {
			Map<String, String> map = new HashMap<>();
			for (int j = 0; j < timeList.size(); j++) {
				map.put(timeList.get(j), (i+1)+"-"+j);
			}
			list.add(map);
		}
		return list;
	}
	
	public static List<List<String>> cteatePdf() {
		//查询出这个人时间列表
		List<String> timeList = timeList();
		if(null != timeList && timeList.size()>0) {
			//查询出这个人序号，检查项目表
			List<List<String>> numList = numList();
			if(null != numList && numList.size()>0) {
				//查询这个人的所有诊断记录
				List<Map<String, String>> dataList = dataList();
				if(null != dataList && dataList.size()>0) {
					List<List<String>> rlist = new ArrayList<>();
					for (int i = 0; i < numList.size(); i++) {
						List<String> list = new ArrayList<>();
						list.addAll(numList.get(i));
						for (int j = 0; j < timeList.size(); j++) {
							Map<String, String> map = dataList.get(i);
							list.add(map.get(timeList.get(j)));
						}
						rlist.add(list);
					}
					return rlist;
				}
			}
		}
		return null;
	}
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("title", "基本检测数值");
		map.put("key0", "病历号：");
		map.put("key1", "2018782344455");
		map.put("key2", "");
		map.put("key3", "手机号：");
		map.put("key4", "13245677654");
		map.put("value0", "姓名");
		map.put("value1", "吴正英");
		map.put("value2", "检测\n科目");
		map.put("value3", "一般检查");
		map.put("value4", "");
		map.put("value5", "性别");
		map.put("value6", "男");
		map.put("value7", "年龄");
		map.put("value8", "38");
		
		List<List<String>> list = cteatePdf();
		String creatPdf = Test1.creatPdf(map, list, "鬼脸任务.pdf", "D:\\download\\logo\\logo_pdf.png");
		System.out.println(creatPdf);
	}
}
