package leetcode.algorithms;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huoxianwei
 * @date 2019/7/9 15:01
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 */
public class Test17 {

    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
    }

    public static List<String> test (String str) {
        List<String> list = new ArrayList<>();
        if (null != str && !"".equals(str)) {
            next("", str, list);
        }
        return list;
    }

    public static void next (String letter, String str, List<String> list) {
        String c = str.substring(0, 1);
        String letters = map.get(c);
        for (int i = 0; i < letters.length(); i++) {
            String e = letter + letters.substring(i, i + 1);
            if (str.length() == 1) {
                list.add(e);
            } else {
                next(e, str.substring(1), list);
            }
        }
    }

    public static void main(String[] args) {
        String str = "";
        List<String> test = test(str);
        System.out.println(JSON.toJSONString(test));
    }
}
