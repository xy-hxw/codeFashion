package com.common.until;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.google.gson.Gson;

public class CommonUtils {
	private static final String KEY_MD5 = "MD5";
	public static boolean isEmpty(String str){
		if(null == str || "".equals(str)){
			return true;
		}else{
			return false;
		}
	}
	public static boolean isNotEmpty(String str){
		if(null != str && !"".equals(str)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 文件上传
	 * @param request 获取文件流
	 * @param path 文件存放地址
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static List<Map<String,String>> uploadFiles(HttpServletRequest request, String path) throws IllegalStateException, IOException{
		if(isEmpty(path)){
			return null;
		}else{
			File rootpath = new File(path);
			if(!rootpath.exists()){
				rootpath.mkdirs();
			}
		}
		//创建一个通用的多部分解析器
		ServletContext servletContext = request.getSession().getServletContext();
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(servletContext);
		//判断 request 是否有文件上传,即多部分请求
		if(multipartResolver.isMultipart(request)){
			//返回上传的文件名
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			//转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			//取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while(iter.hasNext()){
				//取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if(null != file){
					//取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					//如果名称不为"",说明该文件存在，否则说明该文件不存在
					if(null != myFileName && !"".equals(myFileName.trim())){
						//重命名上传后的文件名
						String currentTime = currentTime("yyyyMMddHHmmss");
						String fileName = currentTime + "_" + randomNum(6) + "_" + file.getOriginalFilename();
						//定义上传路径
						String filepath = path + fileName;
						File localFile = new File(filepath);
						file.transferTo(localFile);
						Map<String, String> map = new HashMap<String, String>();
						map.put("fileName", myFileName);
						map.put("newFileName", fileName);
						list.add(map);
					}
				}
			}
			return list;
		}
        return null;
    }
	/**
	 * 获取当前时间
	 * @param style
	 * @return
	 */
	public static String currentTime(String style){
		if(null == style || "".equals(style)){
			style = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat format = new SimpleDateFormat(style);
		String date = format.format(new Date());
		return date;
	}
	/**
	 * MD5加密
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encryptMD5(String data) throws Exception {
		if(isEmpty(data)) {
			return null;
	    }
	    MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
	    md5.update(data.getBytes());
	    byte s[] = md5.digest();
	    StringBuffer sb = new StringBuffer();
	    for(int i = 0; i < s.length; i++) {
	      sb.append(Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6));
	    }
	    return sb.toString();
	}
	/**
	 * 解析properties文件
	 * @param path
	 * @param key
	 * @return
	 */
	public static String loadProperties(String path, String key){
		try {
			if(isEmpty(key) || isEmpty(path)){
				return null;
			}
			Properties p = new Properties();
			InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
			p.load(resourceAsStream);
			return p.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 生成随机数
	 * @param num
	 * @return
	 */
	public static String randomNum(int num){
		String str = "";
		Random random = new Random();
		for(int i=0; i<num; i++){
			int nextInt = random.nextInt(10);
			str = str + nextInt;
		}
		return str;
	}
	/**
	 * 将字节数组转换为十六进制字符串
	 * @param b
	 * @return
	 */
	public static String byteToHexStr(byte[] mByte){
		final String HEX = "0123456789abcdef";
		StringBuilder sb = new StringBuilder(mByte.length * 2);
		for (int i = 0; i < mByte.length; i++) {
			byte b = mByte[i];
			sb.append(HEX.charAt((b>>4) & 0x0f));
			sb.append(HEX.charAt((b & 0x0f)));
		}
		return sb.toString();
	}
	public static void main(String[] args) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 3; i++) {
			Map<String, Object> map1 = new HashMap<String, Object>();
			List<Map<String, String>> list1 = new ArrayList<Map<String, String>>();
			map1.put("name", "菜单"+(i+1));
			for (int j = 0; j < 5; j++) {
				Map<String, String> map2 = new HashMap<String, String>();
				map2.put("type", "click");
				map2.put("name", "菜单_"+i+"_"+j);
				map2.put("key", "key_"+i+"_"+j);
				list1.add(map2);
			}
			map1.put("sub_button", list1);
			list.add(map1);
		}
		map.put("button", list);
		Gson gson = new Gson();
		String s = gson.toJson(map);
		System.out.println(s);
	}
	/**
	 * 将时间加多少时间
	 * @param time 时间 
	 * @param num  加多少(整数加，负数减)
	 * @param type 加的时间类型(秒,分,时,天,周,月,年)
	 * @param style 返回的时间格式
	 * @return
	 */
	public static String addTime(String time, int num, String type, String style){
		if(null == style || "".equals(style)){
			style = "yyyy-MM-dd HH:mm:ss";
		}
		 SimpleDateFormat format = new SimpleDateFormat(style);
		 try {
			Date date = format.parse(time);
			Calendar calendar = Calendar.getInstance ();
			calendar.setTime(date);
			if("second".equals(type)){
				calendar.add (Calendar.SECOND, num);
			}else if("minute".equals(type)){
				calendar.add (Calendar.MINUTE, num);
			}else if("hour".equals(type)){
				calendar.add (Calendar.HOUR, num);
			}else if("day".equals(type)){
				calendar.add (Calendar.DATE, num);
			}else if("week".equals(type)){
				calendar.add (Calendar.WEEK_OF_YEAR, num);
			}else if("month".equals(type)){
				calendar.add (Calendar.MONTH, num);
			}else if("year".equals(type)){
				calendar.add (Calendar.YEAR, num);
			}
			return format.format(calendar.getTime ());
		} catch (ParseException e) {
			return null;
		}
	}
	/**
	 * 起始日期，结束日期
	 * 日期均不能为空，并且结束日期大于等于开始日期
	 * @param startTime
	 * @param endTime
	 * @param style  yyyy-MM-dd  yyyy-MM   yyyy
	 * @return
	 */
	public static List<String> loadDate(String startTime, String endTime, String style) {
		if(null==startTime || "".equals(startTime) || null==endTime || "".equals(endTime)){
			return null;
		}
		Calendar startDay = Calendar.getInstance();  
		Calendar endDay = Calendar.getInstance();
		DateFormat format = new SimpleDateFormat(style); 
		try {
			startDay.setTime(format.parse(startTime));
			endDay.setTime(format.parse(endTime)); 
		} catch (ParseException e) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		if (startDay.compareTo(endDay) > 0) {
			return null;  
		}else{
			list.add(format.format(endDay.getTime()));
		}
		Calendar currentPrintDay = endDay;
		while (currentPrintDay.compareTo(startDay)>0) {  
			//日期加一
			if("yyyy-MM-dd".equals(style)){
				currentPrintDay.set(Calendar.DATE, currentPrintDay.get(Calendar.DATE) - 1);
			}else if("yyyy-MM".equals(style)){
				currentPrintDay.set(Calendar.MONTH, currentPrintDay.get(Calendar.MONTH) - 1);
			}else if("yyyy".equals(style)){
				currentPrintDay.set(Calendar.YEAR, currentPrintDay.get(Calendar.YEAR) - 1);
			}
			list.add(format.format(currentPrintDay.getTime()));
		}
		return list;
	}
}
