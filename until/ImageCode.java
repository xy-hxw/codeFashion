package com.common.until;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 生成随机验证码
 * @author Administrator
 *
 */
public class ImageCode extends HttpServlet implements Servlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void createImageCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        //生成随机字串 
        String loginCode = generateVerifyCode(4);
        //存入会话session
        HttpSession session = request.getSession(true);
        //删除以前的
        session.removeAttribute("code");
        session.setAttribute("code", loginCode.toLowerCase());
        //生成图片 
        int width = 100, height = 33;
        outImageCode(width, height, response.getOutputStream(), loginCode);
	}
	/**
	 * 生成随机字符串
	 * @param num
	 * @return
	 */
	private String generateVerifyCode(int num){
		String codes = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";
		int j = codes.length()-1;
		Random rand = new Random(System.currentTimeMillis());
		StringBuffer buffer = new StringBuffer(num);
		for (int i = 0; i < num; i++) {
			buffer.append(codes.charAt(rand.nextInt(j)));
		}
		return buffer.toString();
	}
	/**
	 * 输出验证码图片
	 * @throws IOException 
	 */
	private void outImageCode(int width, int height, ServletOutputStream sos, String code) throws IOException{
		int codeSize = code.length();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Random rand = new Random();
		Graphics2D g2 = image.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Color[] colors = new Color[5];
		Color[] colorSpace = new Color[]{Color.WHITE, Color.CYAN, Color.GRAY, Color.LIGHT_GRAY, Color.MAGENTA,
				Color.ORANGE, Color.PINK, Color.YELLOW};
		float[] fractions = new float[colors.length];
		for (int i = 0; i < colors.length; i++) {
			colors[i] = colorSpace[rand.nextInt(colorSpace.length)];
			fractions[i] = rand.nextFloat();
		}
		Arrays.sort(fractions);
		
		//设置边框颜色
		g2.setColor(Color.GRAY);
		g2.fillRect(0, 0, width, height);
		
		//设置背景色
		Color c = getRandColor(200, 250);
		g2.setColor(c);
		g2.fillRect(0, 2, width, height);
		
		//制造干扰线
		Random random = new Random();
		Color lineColor = getRandColor(160, 200);
		g2.setColor(lineColor);
		for (int i = 0; i < 20; i++) {
			int x = random.nextInt(width)-1;
			int y = random.nextInt(height)-1;
			int x1 = random.nextInt(6)-1;
			int y1 = random.nextInt(12)-1;
			g2.drawLine(x, y, x+x1+40, y+y1+20);
		}
		
		//添加噪点
		float rate = 0.05f;
		int area = (int)(rate*width*height);
		for (int i = 0; i < area; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int rgb = getRandomIntColor();
			image.setRGB(x, y, rgb);
		}
		
		//使图片扭曲
		g2.setColor(getRandColor(100, 160));
		int fontSize = height - 10;
		Font font = new Font("Algerian", Font.ITALIC, fontSize);
		g2.setFont(font);
		char[] chars = code.toCharArray();
		for(int i = 0; i < codeSize; i++){
			AffineTransform affine = new AffineTransform();
            affine.setToRotation(Math.PI/4*rand.nextDouble()*(rand.nextBoolean()?1:-1),(width/codeSize)*i + fontSize/2, height/2);
            g2.setTransform(affine);
            g2.drawChars(chars, i, 1, ((width-10) / codeSize) * i + 5, height/2 + fontSize/2 - 2);
        }
		
		g2.dispose();
		ImageIO.write(image, "jpg", sos);
	}
	private Color getRandColor(int fc, int bc){
		if(fc>255){fc=255;}
		if(bc>255){bc=255;}
		Random rand = new Random();
		int r = fc + rand.nextInt(bc - fc);
		int g = fc + rand.nextInt(bc - fc);
		int b = fc + rand.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	private int getRandomIntColor(){
		int[] rgb = new int[3];
		Random rand = new Random();
		for (int i = 0; i < 3; i++) {
			rgb[i]=rand.nextInt(255);
			
		}
		int color = 0;
		for(int c : rgb){
			color = color<<8;
			color = color | c;
		}
		return color;
	}
}
	
