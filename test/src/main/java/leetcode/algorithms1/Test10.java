package leetcode.algorithms1;

import java.util.regex.Pattern;

/**
 * @author huoxianwei
 * @date 2019/7/5 14:31
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 */
public class Test10 {

    public static boolean test (String s, String p) {
        return Pattern.matches(p, s);
    }

    public static boolean match (String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = (!s.isEmpty() && (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.'));
        if (p.length() >=2 && p.charAt(1) == '*') {
            return match(s, p.substring(2)) || (firstMatch && match(s.substring(1), p));
        } else {
            return firstMatch && match(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        String p = "a*cdefg";
//        boolean test = test(s, p);
//        System.out.println(test);
        boolean match = match(s, p);
        System.out.println(match);
    }
}
