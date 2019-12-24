package leetcode.algorithms1;

/**
 * @author huoxianwei
 * @date 2019/7/8 9:25\
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 */
public class Test14 {

    public static String test (String[] array) {
        if (null == array || array.length == 0) {
            return "";
        }
        for (int i = 0; i < array[0].length(); i++) {
            char at = array[0].charAt(i);
            for (String s : array) {
                if (i > s.length() - 1 || at != s.charAt(i)) {
                    return array[0].substring(0, i);
                }
            }
        }
        return array[0];
    }

    public static void main(String[] args) {
        String[] str = {};
        String test = test(str);
        System.out.println(test);
    }
}
