package leetcode.algorithms2;

/**
 * @author huoxianwei
 * @date 2020/1/14 11:23
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 斐波那契数列
 */
public class Test91 {

    private static int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            //如果该位不为'0'，说明该位可以单独成字母合法
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            //如果后两位能组成"1x"（x为任意数字）或者"2x"（x小于7），说明最后两位组成字母合法
            if ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "3251";
        int i = numDecodings(s);
        System.out.println(i);
    }
}
