package leetcode.algorithms;

/**
 * @author huoxianwei
 * @date 2019/8/13 15:24
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1
 *
 */
public class Test28 {

    public static int test (String haystack, String needle) {
        if (null == needle || "".equals(needle)) {
            return 0;
        }
        for (int j = 0; j < haystack.length(); j++) {
            if (haystack.charAt(j) == needle.charAt(0)) {
                if (j+needle.length() > haystack.length()) {
                    return -1;
                } else {
                    String str = haystack.substring(j, j + needle.length());
                    if (str.equals(needle)) {
                        return j;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "aaa";
        String needle = "aaaa";
        haystack.indexOf(needle);
        int test = test(haystack, needle);
        System.out.println(test);
    }
}
