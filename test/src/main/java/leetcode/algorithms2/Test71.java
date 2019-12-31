package leetcode.algorithms2;

import java.util.Stack;

/**
 * @author huoxianwei
 * @date 2019/12/31 17:14
 */
public class Test71 {

    private static String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String s1 : s) {
            if (!stack.isEmpty() && "..".equals(s1)) {
                stack.pop();
            } else if (!"".equals(s1) && !".".equals(s1) && !"..".equals(s1)) {
                stack.push(s1);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder res = new StringBuilder();
        for (String s1 : stack) {
            res.append("/").append(s1);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "/a/./b/../../c/";
        String s = simplifyPath(str);
        System.out.println(s);
    }
}
