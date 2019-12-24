package leetcode.algorithms1;

/**
 * @author huoxianwei
 * @date 2019/12/24 9:56
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class Test50 {

    private static double fastPow (double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    private static double myPow (double x, int n) {
        long n1 = n;
        if (n1 < 0) {
            x = 1 / x;
            n1 = -n1;
        }
        return fastPow(x, n1);
    }

    private static double myPow1 (double x, int n) {
        long n1 = n;
        if (n1 < 0) {
            x = 1 / x;
            n1 = -n1;
        }
        double ans = 1;
        double currentProduct = x;
        for (long i = n1; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * currentProduct;
            }
            currentProduct = currentProduct * currentProduct;
        }
        return ans;
    }

    public static void main(String[] args) {
        double v = myPow (2.00000, 2);
        System.out.println(v);
    }
}
