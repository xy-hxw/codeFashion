package leetcode.algorithms;

import java.util.Stack;

/**
 * @author huoxianwei
 * @date 2019/10/15 11:45
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 */
public class Test32 {

    private static int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        String str = ")(()))";
        int i = longestValidParentheses(str);
        System.out.println(i);
    }
}
