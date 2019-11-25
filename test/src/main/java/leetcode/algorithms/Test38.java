package leetcode.algorithms;

/**
 * @author huoxianwei
 * @date 2019/11/22 17:10
 */
public class Test38 {

    private static String countAndSay(int n) {
        StringBuilder str = new StringBuilder("1");
        if (n != 1) {
            for (int j = 1; j < n; j++) {
                char temp = 0;
                int num = 0;
                String s = str.toString();
                str.delete(0, str.length());
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (temp == c) {
                        num = num + 1;
                    } else {
                        if (temp != 0 && num != 0) {
                            str.append(num).append(temp);
                        }
                        temp = c;
                        num = 1;
                    }
                }
                if (str.length() == 1) {
                    str.append(temp);
                } else {
                    str.append(num).append(temp);
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = countAndSay(3);
        System.out.println(s);
    }
}