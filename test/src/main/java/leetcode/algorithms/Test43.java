package leetcode.algorithms;

/**
 * @author huoxianwei
 * @date 2019/12/16 17:31
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class Test43 {
    /**
     * 转换成大数
     * @param num1 乘数
     * @param num2 被乘数
     * @return 积
     */
    private static String multiply (String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }
            result.append(res[i]);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String num1 = "2";
        String num2 = "3";
        String multiply = multiply(num1, num2);
        System.out.println(multiply);
    }
}
