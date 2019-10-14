package leetcode.algorithms;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huoxianwei
 * @date 2019/10/11 11:57
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 */
public class Test30 {

    private static List<Integer> findSubstring (String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (null == s || "".equals(s) || null == words || words.length == 0) {
            return list;
        } else {
            Map<String, Integer> wordMap = new HashMap<>(words.length);
            int length = 0;
            for (String word : words) {
                length = word.length() + length;
                wordMap.merge(word, 1, (a, b) -> a + b);
            }
            int size = words[0].length();
            for (int i = 0; i < s.length()-length+1; i++) {
                Map<String, Integer> map = new HashMap<>(words.length);
                String temp = s.substring(i, i+length);
                for (int j = 0; j < words.length; j++) {
                    String key = temp.substring(j*size, (j+1)*size);
                    map.merge(key, 1, (a, b) -> a + b);
                }
                if (wordMap.equals(map)) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    private static String[] split () {
        String str = "123456789";
        Map<String, Integer> map = new HashMap<>(3);
        for (int j = 0; j < 3; j++) {
            String key = str.substring(j * 3, (j + 1) * 3);
            map.merge(key, 1, (a, b) -> a + b);
        }
        System.out.println(JSON.toJSONString(map));
        return null;
    }

    public static void main(String[] args) {
        String str = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        List<Integer> list = findSubstring(str, words);
        System.out.println(JSON.toJSONString(list));
    }
}
