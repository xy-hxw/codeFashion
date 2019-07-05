package leetcode.algorithms;

/**
 * @author huoxianwei
 * @date 2019/7/5 17:37
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 */
public class Test12 {

    public static String test (int num) {
        int[] a = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] b = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            int times = num / a[i];
            if (times != 0) {
                for (int i1 = 0; i1 < times; i1++) {
                    sb.append(b[i]);
                }
            }
            num = num - times*a[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 1322;
        String test = test(num);
        System.out.println(test);
    }
}
