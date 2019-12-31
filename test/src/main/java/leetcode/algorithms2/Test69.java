package leetcode.algorithms2;

/**
 * @author huoxianwei
 * @date 2019/12/31 10:42
 *
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class Test69 {

    private int s;

    private int mySqrt(int x) {
        s=x;
        if(x==0) {
            return 0;
        }
        return ((int)(sqrts(x)));
    }

    /**
     * 牛顿迭代法
     * @param x 参数
     * @return 平方根
     */
    private double sqrts(double x){
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrts(res);
        }
    }

    /**
     * 二分法
     * @param x 参数
     * @return 平方根
     */
    private static double mySqrt1 (int x){
        if (x == 1 || x == 0) {
            return x;
        }
        int start = 1;
        int end = x / 2 + 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            //防止越界
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            }
            if (mid > x / mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int n = 4;
        int i = new Test69().mySqrt(n);
        System.out.println(i);
        double v = mySqrt1(n);
        System.out.println(v);
    }
}
