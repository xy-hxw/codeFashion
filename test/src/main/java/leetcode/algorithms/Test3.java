package leetcode.algorithms;

import com.google.common.collect.Maps;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author huoxianwei
 * @date 2019/6/25 10:58
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 *
 * 滑动窗口
 */
public class Test3 {

    /**
     * 循环次数最少
     * @param s 字符串
     * @return 不重复字符最长子串
     */
    public static int test (String s) {
        int length = s.length();
        int max = 0;
        Map<Character, Integer> map = Maps.newHashMap();
        for (int i = 0, j = 0; j < length; j++) {
            char c = s.charAt(j);
            Integer index = map.get(c);
            if (null != index) {
                i = Math.max(i, index);
            }
            max = Math.max(max, j-i+1);
            map.put(c, j + 1);
        }
        return max;
    }

    /**
     * 最小内存
     * @param s 字符串
     * @return 含有最少字符的字符串
     */
    public static int test1 (String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "zdzedbzf";
        int max = test(str);
        System.out.println(max);
        int max1 = test1(str);
        System.out.println(max1);
    }
}
