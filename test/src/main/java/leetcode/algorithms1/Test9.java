package leetcode.algorithms1;

/**
 * @author huoxianwei
 * @date 2019/7/5 14:25
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Test9 {

    public static boolean test (int num) {
        if (num < 0) {
            return false;
        }
        String s = String.valueOf(num);
        String reverse = (new StringBuilder(s)).reverse().toString();
        return s.equals(reverse);
    }

    public static void main(String[] args) {
        boolean test = test(121);
        System.out.println(test);
    }
}
