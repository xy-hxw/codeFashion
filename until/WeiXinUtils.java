package com.common.until;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

/**
 * 微信工具类
 * @author hxw
 *
 */
public class WeiXinUtils {
	private final static Logger log = Logger.getLogger(WeiXinUtils.class);
	/**
	 *  获取access_token
	 */
	public static String loadAccessToken(){
		try {
			String appid="wxcd2ff053392822d2";
			String secret="3a48b7b2444529056e76e55a04cd8d6a";
//			String appid = CommonUtils.loadProperties("/config.properties","appid");
//			String secret = CommonUtils.loadProperties("/config.properties","secret");
			String requestUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
			JsonObject httpsRequest = HttpClientUtils.httpsRequest(requestUrl, "GET", null);
			Object errcode = httpsRequest.get("errcode");
			if(null != errcode){
				log.error("获取access_token异常，错误码为:"+errcode);
			}else{
				String access_token = httpsRequest.get("access_token").getAsString();
				return access_token;
			}
		} catch (Exception e) {
			log.error("获取access_token异常");
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		loadAccessToken();
	}
}
