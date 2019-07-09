package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author huoxianwei
 * @date 2019/7/9 20:00
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
 */
public class Test20 {
    public static boolean test (String str) {
        Map<Character, Character> map = new HashMap<>(str.length());
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                char top = stack.empty() ? '#':stack.pop();
                if (top != map.get(c)) {
                    return Boolean.FALSE;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String str = "[";
        boolean test = test(str);
        System.out.println(test);
    }
}
