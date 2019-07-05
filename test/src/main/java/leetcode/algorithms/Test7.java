package leetcode.algorithms;

/**
 * @author huoxianwei
 * @date 2019/7/3 14:09
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Test7 {

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            int i = Integer.MAX_VALUE / 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static int test (int x) {
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
            return 0;
        }
        boolean b = false;
        if (x < 0) {
            x = Math.abs(-x);
            b = true;
        }
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
            if (i == 1) {
                Integer num = Integer.valueOf(sb.toString());
                if (num > Integer.MAX_VALUE/10 || num < Integer.MIN_VALUE/10) {
                    return 0;
                }
            }
        }
        int num = Integer.valueOf(sb.toString());
        if (b) {
            num = num * -1;
        }
        return num;
    }

    public static void main(String[] args) {
        int x = -123;
        int reverse = reverse(x);
        System.out.println(reverse);
        int test = test(x);
        System.out.println(test);
    }
}

