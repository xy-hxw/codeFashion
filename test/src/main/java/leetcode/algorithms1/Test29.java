package leetcode.algorithms1;

/**
 * @author huoxianwei
 * @date 2019/8/21 21:15
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 */
public class Test29 {
    private static int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if (dividend>0) {
            dividend = -dividend;
        }
        if (divisor>0) {
            divisor = -divisor;
        }
        while (dividend <= divisor) {
            int tempResult = -1;
            int tempDivisor = divisor;
            while(dividend <= (tempDivisor << 1)) {
                if (tempDivisor <= (Integer.MIN_VALUE >> 1)) {
                    break;
                }
                tempResult = tempResult << 1;
                tempDivisor = tempDivisor << 1;
            }
            dividend = dividend - tempDivisor;
            result += tempResult;
        }
        if (!sign) {
            if (result <= Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            result = - result;
        }
        return result;
    }

    public static void main(String[] args) {
        int dividend = 15;
        int divisor = 3;
        int divide = divide(dividend, divisor);
        System.out.println(divide);
    }
}

