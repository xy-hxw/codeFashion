package leetcode.algorithms2;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2019/12/30 16:54
 *
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 */
public class Test68 {

    private static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> rlist = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int size = 0;
        for (String word : words) {
            if (size + word.length() > maxWidth) {
                rlist.add(insertBlank(list, maxWidth));
                list = new ArrayList<>();
                size = 0;
            }
            size = size + word.length() + 1;
            list.add(word + " ");
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        int blank = maxWidth - sb.length();
        for (int i = 1; i <= blank; i++) {
            sb.append(" ");
        }
        rlist.add(sb.toString());
        return rlist;
    }

    private static String insertBlank (List<String> list, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        if (list.size() == 1) {
            sb.append(list.get(0));
            int blank = maxWidth - list.get(0).length();
            for (int i = 1; i <= blank; i++) {
                sb.append(" ");
            }
        } else {
            list.set(list.size()-1, list.get(list.size()-1).trim());
            int size = 0;
            for (String s : list) {
                size = size + s.length();
            }
            int blank = maxWidth - size;
            int num = blank/(list.size()-1);
            int length = blank%(list.size()-1);
            StringBuilder blankString = new StringBuilder();
            for (int i = 0; i < num; i++) {
                blankString.append(" ");
            }
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (blankString.length() > 0 && i < list.size() - 1) {
                    sb.append(blankString);
                }
                if (i < length) {
                    sb.append(" ").append(blankString);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"The","important","thing","is","not","to","stop","questioning.","Curiosity","has","its","own","reason","for","existing."};
        int maxWidth = 17;
        List<String> list = fullJustify(words, maxWidth);
        System.out.println(JSON.toJSONString(list));
    }
}
