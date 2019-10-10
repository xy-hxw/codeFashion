package common.code;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.swetake.util.Qrcode;
import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 二维码工具类
 * @author hxw
 */
public class CodeUtils {
	private final static Logger log = Logger.getLogger(CodeUtils.class);
	/**
	 * * QRcode生成二维码
	 * @param codeUrl  需要生成二维码的地址
	 * @param version   版本(7)
	 * @param imageUrl  生成二维码路径
	 */
	private static void createQRcode(String codeUrl, int version, String imageUrl){
		try {
			Qrcode code = new Qrcode();
			// 设置二维码的容错能力等级
			code.setQrcodeErrorCorrect('L');
			// N代表的是数字，A代表的是a-z,B代表的是其他字符
			code.setQrcodeEncodeMode('B');
			code.setQrcodeVersion(version);
			//设置二维码大小
			int width = 67 + 12 * (version - 1);
			int height = 67 + 12 * (version - 1);
			//定义缓冲区图片
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
			//设置画图工具
			Graphics2D gs = image.createGraphics();
			//设置二维码背景颜色
			gs.setBackground(Color.WHITE);
			//设置颜色
			gs.setColor(Color.BLACK);
			//清楚画板内容
			gs.clearRect(0, 0, width, height);
			//定义偏移量
			int pixoff = 2;
			byte[] bytes = codeUrl.getBytes(StandardCharsets.UTF_8);
			int length = 120;
			if(bytes.length < length){
				boolean[][] calQrcode = code.calQrcode(bytes);
				for (int i = 0; i < calQrcode.length; i++) {
					for (int j = 0; j < calQrcode.length; j++) {
						if(calQrcode[j][i]){
							gs.fillRect(j*3+pixoff, i*3+pixoff, 3, 3);
						}
					}
				}
			}
			gs.dispose();
			image.flush();
			File file = new File(imageUrl);
			ImageIO.write(image, "png", file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 解析QRcode二维码
	 * @param imageUrl 二维码路径
	 * @return 解析后信息
	 */
	private static String analysisQRCode(String imageUrl) {
		String result = "";
		try {
			//图片路径
			File file = new File(imageUrl);
			//读取图片到缓冲区
			final BufferedImage bufferedImage = ImageIO.read(file);
			//QRCode解码器
			QRCodeDecoder codeDecoder = new QRCodeDecoder();
			byte[] decode = codeDecoder.decode(new QRCodeImage(){

				@Override
				public int getWidth() {
					return bufferedImage.getWidth();
				}

				@Override
				public int getHeight() {
					return bufferedImage.getHeight();
				}

				@Override
			    public int getPixel(int i, int j) {
			        return bufferedImage.getRGB(i,j);
			    }

			});
			//通过解析二维码获得信息
			result = new String(decode, StandardCharsets.UTF_8);
		} catch (IOException e) {
			log.error("解析二维码出错");
			e.printStackTrace();
		}
        return result;
    }
	/**
	 * 生成ZXing二维码
	 * @param codeUrl  需要生成二维码的地址
	 * @param imageUrl  生成的二维码路径
	 * @param type  图片类型
	 */
	private static void createZXing(String codeUrl, String imageUrl, String type){
		try {
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			//设置二维码容错级别
			Hashtable<EncodeHintType, Object> hintMap = new Hashtable<>();
			// 矫错级别
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			hintMap.put(EncodeHintType.MARGIN, "1");
			int width = 139;
			int height = 139;
			//创建比特矩阵(位矩阵)的QR码编码的字符串
			BitMatrix byteMatrix = qrCodeWriter.encode(codeUrl, BarcodeFormat.QR_CODE, width, height, hintMap);
			int matrixWidth = byteMatrix.getWidth();
			int matrixHeight = byteMatrix.getWidth();
			BufferedImage image = new BufferedImage(matrixWidth, matrixHeight, BufferedImage.TYPE_INT_RGB);
			image.createGraphics();
			Graphics2D graphics = (Graphics2D) image.getGraphics();
			graphics.setColor(Color.WHITE);
			graphics.fillRect(0, 0, matrixWidth, matrixHeight);
			//使用比特矩阵画并保存图像
			graphics.setColor(Color.BLACK);
			for (int i = 0; i < matrixWidth; i++){
				for (int j = 0; j < matrixWidth; j++){
					if (byteMatrix.get(i, j)){
						graphics.fillRect(i, j, 1, 1);
					}
				}
			}
			closeStream(graphics, image, imageUrl, image, type);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 解析ZXing二维码图片
	 * @param imageUrl ZXing二维码路径
	 * @return 路径
	 */
	public static String analysisZXing(String imageUrl) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(imageUrl));
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<>(16);
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            // 对图像进行解码
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);
            return result.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	/**
	 * 
	 * @param imageUrl 二维码路径
	 * @param logoPath logo路径
	 * @param type 图片类型
	 */
	private static void createZXingWithLogo(String codeUrl, String imageUrl, String logoPath, String type){
		try {
			//设置二维码容错级别
			Hashtable<EncodeHintType, Object> hintMap = new Hashtable<>();
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
			hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			hintMap.put(EncodeHintType.MARGIN, "1");
			//创建比特矩阵(位矩阵)的QR码编码的字符串
			int width = 200;
			BitMatrix bitMatrix = new MultiFormatWriter().encode(codeUrl, BarcodeFormat.QR_CODE, width, 200, hintMap);
			int imageWidth = bitMatrix.getWidth();
			int imageHeight = bitMatrix.getWidth();
			BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
			int black = 0xFF000000;
			int white = 0xFFFFFFFF;
			for(int x=0;x<width;x++){
	            for(int y=0;y<width;y++){
	                image.setRGB(x, y, bitMatrix.get(x, y) ? black : white);
	            }
	        }
			Graphics2D gs = image.createGraphics();
			//载入logo  
	        Image img = ImageIO.read(new File(logoPath));
	        gs.drawImage(img, 75, 75, null);
			closeStream(gs, img, imageUrl, image, type);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void closeStream (Graphics2D gs, Image img, String imageUrl, BufferedImage image, String type) throws IOException {
		gs.dispose();
		img.flush();
		File file = new File(imageUrl);
		boolean write = ImageIO.write(image, type, file);
		System.out.println(write);
	}

	public static void main(String[] args) {
		int version = 7;
		String jpg = "jpg";
		String jpeg = "JPEG";
		String imageUrl = "D:/12313.jpg";
		String codeUrl = "https://www.baidu.com/index.html?activityId=9E859E75E";
		String logoPath = "D:/image001.jpg";
//		// 日本的二维码生成
//		createQRcode(codeUrl, version, imageUrl);
//		// 日本的二维码解析
//		String str = analysisQRCode(imageUrl);
//		System.out.println("日本="+str);
		// google zxing 二维码生成

		StringBuilder sb = new StringBuilder();
		sb.append("BEGIN:VCARD").append("\n");
		sb.append("VERSION:3.0").append("\n");
		sb.append("FN:马强").append("\n");
		sb.append("TITLE:产品").append("\n");
		sb.append("TEL;CELL:18211021902").append("\n");
		sb.append("EMAIL;TYPE=PREF,INTERNET:maqiang11@jd.com").append("\n");
		sb.append("ORG:京东数字科技").append("\n");
		sb.append("URL:https://www.baidu.com/").append("\n");
		sb.append("END:VCARD");
		codeUrl = sb.toString();
//
		createZXing(codeUrl, imageUrl, jpg);
		// google zxing 二维码解析
		String str1 = analysisZXing(imageUrl);
		System.out.println("google="+str1);
//		// google zxing 有logo的二维码生成
//		createZXingWithLogo(codeUrl, imageUrl, logoPath, jpeg);
//		String strByLogo = analysisZXing(imageUrl);
//		System.out.println("google logo="+strByLogo);
	}
}

