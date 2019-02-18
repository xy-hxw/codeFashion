package common.file;

import common.code.CodeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @author hxw
 */
public class FileUtil {

	/**
	 * 获取当前时间
	 * @param style 时间格式
	 * @return 当前时间字符串
	 */
	private static String currentTime(String style){
		if(StringUtils.isBlank(style)){
			style = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat format = new SimpleDateFormat(style);
		return format.format(new Date());
	}

	/**
	 * 生成随机数
	 * @param num 随机数个数
	 * @return 随机数字符串
	 */
	private static String randomNum(int num){
		StringBuilder str = new StringBuilder();
		for(int i=0; i<num; i++){
			int nextInt = ThreadLocalRandom.current().nextInt(10);
			str.append(nextInt);
		}
		return str.toString();
	}

	/**
	 * 文件上传
	 * @param request 获取文件流
	 * @param path 文件存放地址
	 * @return 上传后文件路径
	 */
	public static List<Map<String,String>> uploadFiles(HttpServletRequest request, String path) {
		if (StringUtils.isBlank(path)) {
			return null;
		} else {
			File rootpath = new File(path);
			if(!rootpath.exists()){
				if (rootpath.mkdirs()) {
					System.out.println("create file path success !");
				}
			}
		}
		//创建一个通用的多部分解析器
		ServletContext servletContext = request.getSession().getServletContext();
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(servletContext);
		//判断 request 是否有文件上传,即多部分请求
		if(multipartResolver.isMultipart(request)){
			//返回上传的文件名
			List<Map<String, String>> list = new ArrayList<>();
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
						String style = "yyyyMMddHHmmss";
						String currentTime = currentTime(style);
						int num = 6;
						String fileName = currentTime + "_" + randomNum(num) + "_" + file.getOriginalFilename();
						//定义上传路径
						String filepath = path + fileName;
						File localFile = new File(filepath);
						try {
							file.transferTo(localFile);
						} catch (IOException e) {
							e.printStackTrace();
						}
						Map<String, String> map = new HashMap<>(2);
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
	 * @param url 压缩包路径
	 * @param fileName 压缩包名称
	 */
	private static void zipTest(String url, String fileName) {
		String path = url+fileName;
		ZipFile zf;
		try {
			zf = new ZipFile(path);
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
			}
			zin.closeEntry();
			zf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	public static void main(String[] args) {
		String url = "D:/";
		String fileName = "code.zip";
		zipTest(url, fileName);
	}
}
