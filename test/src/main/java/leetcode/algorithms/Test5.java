package leetcode.algorithms;

import org.apache.commons.lang3.StringUtils;

/**
 * @author huoxianwei
 * @date 2019/7/3 10:18
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
 *
 * 围绕中心点向两边扩散
 *
 */
public class Test5 {

    public static String test (String str) {
        if (null == str || "".equals(str)) {
            return "";
        }
        int start=0, end=0;
        for (int i = 0; i < str.length(); i++) {
            int len1 = center(str, i, i);
            int len2 = center(str, i, i+1);
            int max = Math.max(len1, len2);
            if (max > end - start) {
                start = i - (max -1)/2;
                end = i + max/2;
            }
        }
        return str.substring(start, end+1);
    }

    private static int center (String str, int left, int right) {
        int l = left, r = right;
        while (l>=0 && r<str.length() && str.charAt(l)==str.charAt(r)) {
            l--;
            r++;
        }
        return r-l-1;
    }

    public static String test1 (String str) {
        if (null == str || "".equals(str)) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }
        int length = 1;
        String rstr = str.substring(0,1);
        for (int i = 0; i < str.length()-1; i++) {
            for (int j = i+1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    String temp = str.substring(i, j+1);
                    if (judge(temp) && (j+1-i)>length) {
                        length = j+1-i;
                        rstr = temp;
                    }
                }
            }
        }
        return rstr;
    }

    private static boolean judge(String str) {
        String str1 = StringUtils.reverse(str);
        return str1.equals(str);
    }

    public static void main(String[] args) {
        String str = "csddbdd";
        String s = test(str);
        System.out.println(s);
    }
}
