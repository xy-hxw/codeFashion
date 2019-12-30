package leetcode.algorithms2;

/**
 * @author huoxianwei
 * @date 2019/12/30 15:59
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 */
public class Test67 {

    private static String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int temp = 0;
        StringBuilder sb = new StringBuilder();
        int k = b.length() - 1;
        for (int i = a.length()-1; i>=0; i--) {
            int a1 = a.charAt(i)-48;
            int b1 = 0;
            if (k >= 0) {
                b1 = b.charAt(k)-48;
                k--;
            }
            sb.append((a1 + b1 + temp)%2);
            if (a1 + b1 + temp >= 2) {
                temp = 1;
            } else {
                temp = 0;
            }
        }
        if (temp > 0) {
            sb.append(temp);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010", b = "111";
        String s = addBinary(a, b);
        System.out.println(s);
    }
}
