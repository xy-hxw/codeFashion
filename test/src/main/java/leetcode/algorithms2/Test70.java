package leetcode.algorithms2;

/**
 * @author huoxianwei
 * @date 2019/12/31 15:02
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Test70 {

    private static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        cal(0, n, memo);
        return 0;
    }

    private static int cal (int sum, int n, int[] memo) {
        if (sum > n) {
            return 0;
        }
        if (sum == n) {
            return 1;
        }
        if (memo[sum] > 0) {
            return memo[sum];
        }
        memo[sum] = cal(sum+1, n, memo) + cal(sum+2, n, memo);
        return memo[sum];
    }

    public int climbStairs1 (int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int i = climbStairs(n);
        System.out.println(i);
    }
}
