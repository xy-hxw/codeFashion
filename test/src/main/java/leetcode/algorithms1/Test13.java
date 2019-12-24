package leetcode.algorithms1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huoxianwei
 * @date 2019/7/5 18:44
 *
 * 罗马数字转换为整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M
 */
public class Test13 {
    
    public static int test (String str) {
        Map<String, Integer> map = new HashMap<>();
        int[] a = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
        int num = 0;
        for (int i = 0; i < str.length();) {
            if (i+1<str.length() && map.containsKey(str.substring(i, i+2))) {
                num = num + map.get(str.substring(i, i+2));
                i = i + 2;
            } else {
                num = num + map.get(str.substring(i, i+1));
                i++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String str = "MCCCXXII";
        int test = test(str);
        System.out.println(test);
    }
}
