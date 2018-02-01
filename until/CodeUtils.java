package com.common.until;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;

import org.apache.log4j.Logger;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.swetake.util.Qrcode;

/**
 * 二维码工具类
 * @author hxw
 *
 */
public class CodeUtils {
	private final static Logger log = Logger.getLogger(CodeUtils.class);
	/**
	 * * QRcode生成二维码
	 * @param codeUrl  需要生成二维码的地址
	 * @param version   版本(7)
	 * @param imageUrl  生成二维码路径
	 */
	public static void createQRcode(String codeUrl, int version, String imageUrl){
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
			byte[] bytes = codeUrl.getBytes("utf-8");
			if(null!=bytes && bytes.length<120){
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
			log.error("生成QRCode二维码异常");
			e.printStackTrace();
		}
	}
	/**
	 * 解析QRcode二维码
	 * @param imageUrl 二维码路径
	 * @return
	 */
	public static String analysisQRCode(String imageUrl) {
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
			result = new String(decode, "utf-8");
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
	public static void createZXing(String codeUrl, String imageUrl, String type){
		try {
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			//设置二维码容错级别
			Hashtable<EncodeHintType, Object> hintMap = new Hashtable<EncodeHintType, Object>();
			// 矫错级别
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			hintMap.put(EncodeHintType.MARGIN, "1");
			int width = 139;
			int height = 139;
			//创建比特矩阵(位矩阵)的QR码编码的字符串
			BitMatrix byteMatrix = qrCodeWriter.encode(codeUrl, BarcodeFormat.QR_CODE, width, height, hintMap);
			int matrixWidth = byteMatrix.getWidth();
			BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
			image.createGraphics();
			Graphics2D graphics = (Graphics2D) image.getGraphics();
			graphics.setColor(Color.WHITE);
			graphics.fillRect(0, 0, matrixWidth, matrixWidth);
			//使用比特矩阵画并保存图像
			graphics.setColor(Color.BLACK);
			for (int i = 0; i < matrixWidth; i++){
				for (int j = 0; j < matrixWidth; j++){
					if (byteMatrix.get(i, j)){
						graphics.fillRect(i, j, 1, 1);
					}
				}
			}
			graphics.dispose();
			image.flush();
			File file = new File(imageUrl);
			OutputStream outputStream = new FileOutputStream(file);
			boolean write = ImageIO.write(image, type, outputStream );
			if(write){
				log.info("生成ZXing二维码");
			}else{
				log.error("未生成ZXing二维码");
			}
		} catch (Exception e) {
			log.error("生成ZXing二维码异常");
			e.printStackTrace();
		}
	}
	/**
	 * 解析ZXing二维码图片
	 * @param imageUrl ZXing二维码路径
	 * @return
	 */
	public static String analysisZXing(String imageUrl) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(imageUrl));
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            // 对图像进行解码
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);
            return result.getText();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
	/**
	 * 
	 * @param imageUrl
	 * @param logoPath
	 * @param type
	 */
	public static void createZXingWithLogo(String codeUrl, String imageUrl, String logoPath, String type){
		try {
			//设置二维码容错级别
			Hashtable<EncodeHintType, Object> hintMap = new Hashtable<EncodeHintType, Object>();
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
			hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			hintMap.put(EncodeHintType.MARGIN, "1");
			//创建比特矩阵(位矩阵)的QR码编码的字符串
			int width = 200;
			BitMatrix bitMatrix = new MultiFormatWriter().encode(codeUrl, BarcodeFormat.QR_CODE, width, width, hintMap);
			int imageWidth = bitMatrix.getWidth();
			BufferedImage image = new BufferedImage(imageWidth, imageWidth, BufferedImage.TYPE_INT_RGB);
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
	        gs.dispose();
	        img.flush();
	        File file = new File(imageUrl);
	        boolean write = ImageIO.write(image, type, file);
	        if(write){
	        	log.info("ZXing生成带logo的二维码");
	        }else{
	        	log.info("ZXing生成带logo的二维码失败");
	        }
		} catch (Exception e) {
			log.error("ZXing生成带logo的二维码异常");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String imageUrl = "F:/code.JPEG";
		String codeUrl = "https://www.baidu.com";
		String logoPath = "F:/image002.jpg";
//		createQRcode(codeUrl, 7, imageUrl);
//		String str = analysisQRCode(imageUrl)
//		createZXing(codeUrl, imageUrl, "JPEG");
//		String str = analysisZXing(imageUrl);
		createZXingWithLogo(codeUrl, imageUrl, logoPath, "JPEG");
		String str = analysisZXing(imageUrl);
		System.out.println(str);
	}
}
