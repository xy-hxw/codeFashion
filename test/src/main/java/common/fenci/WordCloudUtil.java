package common.fenci;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
import com.kennycason.kumo.palette.LinearGradientColorPalette;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordCloudUtil {
	public static void createWord(List<WordFrequency> wordFrequencyList, String path) throws IOException {
		//建立词频分析器，设置词频，以及词语最短长度，此处的参数配置视情况而定即可
		FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(800);
        frequencyAnalyzer.setMinWordLength(2);
        //引入中文解析器
        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
        //指定文本文件路径，生成词频集合
//        final List<WordFrequency> wordFrequencyList = frequencyAnalyzer.load("E:\\爬虫/wordcloud.txt");
        //设置图片分辨率
        Dimension dimension = new Dimension(1920,1080);
        //此处的设置采用内置常量即可，生成词云对象
        WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        //设置边界及字体
        wordCloud.setPadding(2);
        java.awt.Font font = new java.awt.Font("STSong-Light", 2, 20);
        //设置词云显示的三种颜色，越靠前设置表示词频越高的词语的颜色
        wordCloud.setColorPalette(new LinearGradientColorPalette(Color.RED, Color.BLUE, Color.GREEN, 30, 30));
        wordCloud.setKumoFont(new KumoFont(font));
        //设置背景色
        wordCloud.setBackgroundColor(new Color(255,255,255));
        //设置背景图层为圆形
        wordCloud.setBackground(new CircleBackground(400));
        wordCloud.setFontScalar(new SqrtFontScalar(12, 45));
        //生成词云
        wordCloud.build(wordFrequencyList);
        File file = new File(path);
        if(!file.exists()) {
        	file.mkdirs();
        }
        wordCloud.writeToFile(path);
	}
	public static void main(String[] args) {
		String str = "美丽贤淑,有气质,楚楚动人,美丽大方,倾国倾城,大家闺秀,小家碧玉,楚楚动人,"
				+ "闭月羞花,沉鱼落雁,倾国倾城,温婉娴淑,千娇百媚,仪态万千,国色天香,花容月貌,明目皓齿,"
				+ "淡扫峨眉,清艳脱俗,香肌玉肤　仪态万端,婉风流转,美撼凡尘,聘婷秀雅,娥娜翩跹,俏丽多姿,"
				+ "风姿卓越,顾盼流转,清丝纠缠,举步轻摇,明艳不可方物,艳冠群芳,剪水双瞳,美艳绝伦,神仙玉骨,"
				+ "楚楚动人,楚楚动人,温柔善良,风姿绰约,顾盼流转,清丝纠缠,举步轻摇,明艳不可方物,手如柔荑,"
				+ "肤如凝脂,领如蝤蛴,齿如瓠犀,螓首蛾眉,巧笑倩兮,美目盼兮冰雪聪明,惠质兰心,通情达理,睿智,"
				+ "淑德,贤惠,文静,翩若惊鸿,宛若游龙,国色天香,貌若天仙,环肥燕瘦,窈窕淑女,秀丽端庄,艳若桃李,"
				+ "温柔可人,活泼可爱,亭亭玉立,如花似玉,软玉温香,兰质蕙心,秀外慧中,楚楚动人"
				+ ",明眸皓齿,天生丽质,优雅纯朴,稚气俊秀,清秀可爱,楚楚动人,聪颖灵秀,俊俏俊美,美丽,"
				+ "大方,温柔,可爱,单纯,纯洁";
		String[] split = str.split(",");
		List<WordFrequency> list = new ArrayList<WordFrequency>();
		for (int i = 0; i < split.length; i++) {
			WordFrequency word = new WordFrequency(split[i], i);
			list.add(word);
		}
		String path = "D:\\wy.png";
		try {
			createWord(list, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
