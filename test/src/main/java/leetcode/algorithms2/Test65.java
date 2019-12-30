package leetcode.algorithms2;

/**
 * @author huoxianwei
 * @date 2019/12/30 14:38
 *
 * 验证给定的字符串是否可以解释为十进制数字
 */
public class Test65 {

    private static int make(char c) {
        switch(c) {
            case ' ': return 0;
            case '+':
            case '-': return 1;
            case '.': return 3;
            case 'e': return 4;
            default:
                if (c >= 48 && c <= 57) {
                    return 2;
                }
        }
        return -1;
    }

    private static boolean isNumber(String s) {
        int state = 0;
        int finals = 0b101101000;
        int[][] transfer = new int[][]{
                { 0, 1, 6, 2,-1},
                {-1,-1, 6, 2,-1},
                {-1,-1, 3,-1,-1},
                { 8,-1, 3,-1, 4},
                {-1, 7, 5,-1,-1},
                { 8,-1, 5,-1,-1},
                { 8,-1, 6, 3, 4},
                {-1,-1, 5,-1,-1},
                { 8,-1,-1,-1,-1}};
        char[] ss = s.toCharArray();
        for (char s1 : ss) {
            int id = make(s1);
            if (id < 0) {
                return false;
            }
            state = transfer[state][id];
            if (state < 0) {
                return false;
            }
        }
        return (finals & (1 << state)) > 0;
    }

    public static void main(String[] args) {
        String str = "+2.3";
        boolean number = isNumber(str);
        System.out.println(number);
    }
}
