package leetcode.algorithms1;

import java.util.ArrayList;

/**
 * @author huoxianwei
 * @date 2019/7/3 13:54
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 */
public class Test6 {
    public static String test (String str, int rows) {
        if (rows == 1) {
            return str;
        }
        ArrayList<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            list.add(stringBuilder);
        }
        int currentRow = 0;
        boolean goingDown = false;
        for (char c: str.toCharArray()) {
            list.get(currentRow).append(c);
            if (currentRow == 0 || currentRow == (rows - 1)) {
                goingDown = !goingDown;
            }
            currentRow = goingDown?currentRow+1:currentRow-1;
        }
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "abcdefghigklmnopqrstuvwxyz";
        test(str, 3);
    }
}
