package common;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class FileUtil {
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
	 * 读取压缩包图片路径
	 * @param url
	 * @throws IOException
	 */
	public static void zipTest(String url, String fileName) throws IOException {
		String path = url+fileName;
        ZipFile zf = new ZipFile(path);
        InputStream in = new BufferedInputStream(new FileInputStream(path));
        Charset charset = Charset.forName("UTF-8");
        ZipInputStream zin = new ZipInputStream(in, charset);
        ZipEntry ze;
        while((ze = zin.getNextEntry()) != null){
        	if(ze.toString().endsWith("txt")){
        		String imageName = url+ze.getName();
				String analysisZXing = CodeUtils.analysisZXing(imageName);
				System.out.println(imageName +"---" +analysisZXing);
        	}
        };
        zin.closeEntry();
        zf.close();
    }
	public static void main(String[] args) {
		try {
			zipTest("D:/", "code.zip");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
