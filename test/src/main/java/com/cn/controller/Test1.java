package com.cn.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Test1 {
	public static void dealData() {
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
		List<List<String>> list = new ArrayList<>();
		for (int i = 0; i < 400; i++) {
			List<String> times = new ArrayList<>();
			times.add(i+"");
			for (int j = 0; j < 25; j++) {
				times.add(i+"-"+j);
			}
			list.add(times);
		}
		String creatPdf = creatPdf(map, list, "鬼脸任务.pdf", "D:\\download\\logo\\logo_pdf.png");
		System.out.println(creatPdf);
	}
	public static Font setFont(Integer size, Integer bold, BaseColor color) {
		BaseFont bfChinese = null;
		Font font = null;
		try {
			bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			if(null == size) {size = 8;}
			if(null == bold) {bold = -1;}
			if(null == color) {color = BaseColor.BLACK;}
			font = new Font(bfChinese, size, bold, color);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return font;
	}
	public static PdfPCell setStyel(String value, PdfPCell cell) {
		cell = new PdfPCell(new Paragraph(value, setFont(null, null, null)));//单元格内容
		cell.setFixedHeight(25f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
		cell.setBackgroundColor(new BaseColor(253, 253, 253));
		cell.setBorderColor(new BaseColor(217, 217, 217));
		return cell;
	}
	public static String creatPdf(Map<String, String> map, List<List<String>> list, String fileName, String imagePath) {
		String basepath=System.getProperty("java.io.tmpdir");
		File file = new File(basepath);
        if(!file.exists()){
             file.mkdirs();
        }
        String path = "";
		try {
			Rectangle pageSize = new Rectangle(595,842);
			pageSize.setBackgroundColor(new BaseColor(246, 247, 249));
	        Document document = new Document(pageSize);
			path = basepath+fileName;
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
			document.open();
            //添加主题
			int num0 = 2;
			PdfPTable name = new PdfPTable(num0);
            List<PdfPRow> nameList = name.getRows();
            float[] widths = {19,30};
            name.setWidths(widths);
            PdfPCell[] nameCell = new PdfPCell[num0];
            PdfPRow nameRow = new PdfPRow(nameCell);
            //logo
            Image image = Image.getInstance(imagePath);
            image.setAlignment(Image.LEFT);
            image.scaleAbsolute(30, 30);
            nameCell[0] = new PdfPCell(image,true);
            nameCell[0].setFixedHeight(50f);
            nameCell[0].setPadding(4);
            nameCell[0].disableBorderSide(8);
            nameCell[0].setBorderColor(new BaseColor(217, 217, 217));
            nameCell[1] = new PdfPCell(new Paragraph(map.get("title"), setFont(18, Font.BOLD, BaseColor.BLUE)));
            nameCell[1].setFixedHeight(50f);
            nameCell[1].setPaddingTop(12);
            nameCell[1].disableBorderSide(4);
            nameCell[1].setBorderColor(new BaseColor(217, 217, 217));
            nameList.add(nameRow);
            //头部数据1
            int num1=5;
            PdfPTable title0 = new PdfPTable(num1);
            List<PdfPRow> titleRow0 = title0.getRows();
            float[] widths0 = {7f, 15f, 5f, 7f, 15f};
            title0.setWidths(widths0);
            PdfPCell[] titleCell0 = new PdfPCell[num1];
            PdfPRow row01 = new PdfPRow(titleCell0);
            for (int i = 0; i < titleCell0.length; i++) {
            	titleCell0[i] = setStyel(map.get("key"+i), titleCell0[i]);
            	if(i == 2) {
            		titleCell0[i].disableBorderSide(1);
            		titleCell0[i].disableBorderSide(2);
            		titleCell0[i].disableBorderSide(4);
            		titleCell0[i].disableBorderSide(8);
            		titleCell0[i].setBackgroundColor(new BaseColor(246, 247, 249));
            	}
			}
            titleRow0.add(row01);
            document.add(new Paragraph(18f, " "));
            //头部数据2
            int num2=9;
            PdfPTable title1 = new PdfPTable(num2);
            List<PdfPRow> titleRow1 = title1.getRows();
            float[] widths1 = {2f, 5f, 5f, 10f, 5f, 2f, 5f, 5f, 10f};
            title1.setWidths(widths1);
            PdfPCell[] titleCell1 = new PdfPCell[num2];
            PdfPRow row02 = new PdfPRow(titleCell1);
            for (int i = 0; i < titleCell1.length; i++) {
            	titleCell1[i] = setStyel(map.get("value"+i), titleCell1[i]);
            	titleCell1[i].setMinimumHeight(40);
            	if(i == 1 || i == 6) {
            		titleCell1[i].disableBorderSide(8);
            	}
            	if(i == 2 || i == 7) {
            		titleCell1[i].disableBorderSide(4);
            	}
            	if(i == 4) {
            		titleCell1[i].disableBorderSide(1);
            		titleCell1[i].disableBorderSide(2);
            		titleCell1[i].disableBorderSide(4);
            		titleCell1[i].disableBorderSide(8);
            		titleCell1[i].setBackgroundColor(new BaseColor(246, 247, 249));
            	}
            }
            titleRow1.add(row02);
            
            name.setWidthPercentage(100);
            title0.setWidthPercentage(100);
            title1.setWidthPercentage(100);
            document.add(name);
            document.add(new Paragraph(15f, " "));
            document.add(title0);
            document.add(new Paragraph(15f, " "));
            document.add(title1);
            if(null != list && list.size()>0) {
            	int size = list.get(0).size();
            	//列表表头
            	PdfPTable table = new PdfPTable(size);
            	List<PdfPRow> listRow = table.getRows();
            	PdfPCell[] cells0 = new PdfPCell[size];
            	PdfPRow row0 = new PdfPRow(cells0);
            	for (int i = 0; i < cells0.length; i++) {
            		String value = "";
            		if(i>1) {
            			value = (i-2)+"";
            		}
            		cells0[i] = setStyel(value, cells0[i]);
            	}
            	listRow.add(row0);
            	//列表内容
            	list.stream().forEachOrdered(key->{
            		PdfPCell[] cells = new PdfPCell[size];
            		PdfPRow row = new PdfPRow(cells);
            		for (int i = 0; i < cells.length; i++) {
            			cells[i] = setStyel(key.get(i), cells[i]);
            		}
            		listRow.add(row);
            	});
            	table.setWidthPercentage(100);
            	document.add(new Paragraph(7f, " "));
                document.add(table);
            }
            
            document.close();
            writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	public static void main(String[] args) {
		dealData();
	}
}
