package com.common.until;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.jms.TextMessage;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.common.interceptor.SSLX509TrustManager;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pojo.WXMessage;
import com.thoughtworks.xstream.XStream;

public class HttpClientUtils{
	/**
	 * httpClient发送https请求
	 * @param requestUrl   请求的url
	 * @param requestMethod  请求方式(GET/POST),大写
	 * @param outPutParams  请求的参数
	 * @return  请求返回的内容
	 */
	public static JsonObject httpsRequest(String requestUrl, String requestMethod, String outPutParams){
		StringBuffer buffer = null;
		JsonObject jsonObject = null;
		try {
			SSLContext sslContext = SSLContext.getInstance("SSL");
			TrustManager[] tm={new SSLX509TrustManager()};
			sslContext.init(null, tm, new java.security.SecureRandom());
			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod(requestMethod);
			conn.connect();
			//服务器端写的参数
			if(null != outPutParams && !"".equals(outPutParams)){
				OutputStream outputStream = conn.getOutputStream();
				outputStream.write(outPutParams.getBytes());
				outputStream.close();
			}
			//获取服务器端返回的内容
			InputStream is = conn.getInputStream();
			InputStreamReader isr=new InputStreamReader(is,"utf-8");
			BufferedReader br=new BufferedReader(isr);
			buffer=new StringBuffer();
			String line = null;
			while((line = br.readLine())!= null){
				buffer.append(line);
			}
			br.close();
			isr.close();
			is.close();
			conn.disconnect();
			jsonObject = new JsonParser().parse(buffer.toString()).getAsJsonObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	/**
	 * 解析微信返回xml
	 * @param inputStream
	 */
	public static Map<String, String> parseXmlDOM4J(InputStream inputStream){
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(inputStream);
			Element rootElement = document.getRootElement();
			Iterator<?> it = rootElement.elementIterator();
			Map<String, String> map = new HashMap<String, String>();
			while(it.hasNext()){
				Element element = (Element) it.next();
				String name = element.getName();
				String value = element.getStringValue();
				System.out.println(name+"="+value);
				map.put(name, value);
//				List<Attribute> attributes = element.attributes();
//				for (int i = 0; i < attributes.size(); i++) {
//					Attribute attribute = attributes.get(i);
//					String name = attribute.getName();
//					String value = attribute.getValue();
//				}
//				Iterator<Element> elementIterator = element.elementIterator();
//				while(elementIterator.hasNext()){
//					Element content = elementIterator.next();
//					String name = content.getName();
//					String value = content.getStringValue();
//				}
			};
			return map;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
     * 文本消息转化为xml
     * 
     * @param textMessage
     * @return
     */
	public static String changeMessageToXml(WXMessage message) {
        XStream xstream = new XStream();
        xstream.alias("xml", message.getClass());
        return xstream.toXML(message);
    }
	public static void main(String[] args) {
		WXMessage message = new WXMessage();
		message.setContent("12");
		message.setCreateTime("sss");
		String textMessageToXml = changeMessageToXml(message);
		System.out.println(textMessageToXml);
	}
}
