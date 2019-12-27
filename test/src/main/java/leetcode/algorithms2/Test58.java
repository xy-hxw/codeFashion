package leetcode.algorithms2;

/**
 * @author huoxianwei
 * @date 2019/12/27 15:32
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 */
public class Test58 {

    private static int lengthOfLastWord(String s) {
        if (null != s && s.length() > 0) {
            int position = 0;
            int end = 0;
            boolean b = false;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (!b && s.charAt(i) != 32) {
                    position = i+1;
                    b = true;
                }
                if (b && s.charAt(i) == 32) {
                    end = i+1;
                    break;
                }
            }
            return position - end;
        }
        return 0;
    }

    public static void main(String[] args) {
        String str = " ";
        int i = lengthOfLastWord(str);
        System.out.println(i);
    }
}
