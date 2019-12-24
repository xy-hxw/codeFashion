package leetcode.algorithms;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author huoxianwei
 * @date 2019/12/23 19:40
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串
 */
public class Test49 {
    private static List<List<String>> groupAnagrams (String[] strs) {
        Map<String, List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            if (!map.containsKey(String.valueOf(chars))) {
                map.put(String.valueOf(chars), new ArrayList<>());
            }
            map.get(String.valueOf(chars)).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private static List<List<String>> groupAnagrams1 (String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> ans = new HashMap<>(strs.length);
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.println(JSON.toJSONString(list));
        }
    }
}
