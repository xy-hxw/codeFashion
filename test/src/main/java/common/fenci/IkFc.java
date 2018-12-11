package common.fenci;

import java.io.StringReader;

import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.cfg.DefaultConfig;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class IkFc {
	public static void main(String[] args) {
		String text = "在中国进入全面建成小康社会决定性阶段，胡锦涛同志所作的十八大报告，浓缩了改革开放以来特别是最近十年来党领导中国发展建设的经验与启示，勾画出中国未来发展的蓝图。报告中的新表述、新思想、新论断，引发了与会代表和各界干部群众的广泛关注。"; 
//		String text = "基于java语言开发的轻量级的中文分词工具包";
//		String text = "我和你心连心";
		//独立Lucene实现
		
		StringReader re = new StringReader(text.trim());
		IKSegmenter ik = new IKSegmenter(re,true);
		Lexeme lex = null;
		try {
		    while((lex=ik.next())!=null){
		    	System.out.println(lex.getLexemeText());
		    }
		}catch (Exception e) {
		}
	}
}
