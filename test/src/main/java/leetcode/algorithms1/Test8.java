package leetcode.algorithms1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2019/7/5 10:08
 *
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 */
public class Test8 {

    public static int test (String str) {
        char[] temp = {'+', '-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        if (null == str || "".equals(str.trim()) || str.equals("-") || str.equals("+")) {
            return 0;
        }
        str = str.trim();
        boolean flag = false;
        for (char c : temp) {
            if (c == str.charAt(0)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return 0;
        }
        List<Character> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (list.size() == 0) {
                list.add(aChar);
            } else if (aChar >= 48 && aChar <= 57) {
                list.add(aChar);
            } else {
                break;
            }
            if (list.size() >= 9) {
                Long aLong = Long.valueOf(strByList(list));
                if (aLong <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                if (aLong >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        if (list.size() == 0 || (list.size() == 1 && (list.get(0)==43 || list.get(0) == 45))) {
            return 0;
        }
        return Integer.valueOf(strByList(list));
    }

    private static String strByList (List<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "3.1415";
        int test = test(str);
        System.out.println(test);
    }
}
