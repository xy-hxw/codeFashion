package leetcode.algorithms2;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author huoxianwei
 * @date 2019/12/24 11:14
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */
public class Test51 {

    // 不生成 nums 数组，并且使用成员变量

    private Set<Integer> col;
    private Set<Integer> master;
    private Set<Integer> slave;
    private int n;
    private List<List<String>> res;

    private List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        col = new HashSet<>();
        master = new HashSet<>();
        slave = new HashSet<>();

        Stack<Integer> stack = new Stack<>();
        backtrack(0, stack);
        return res;
    }

    private void backtrack(int row, Stack<Integer> stack) {
        if (row == n) {
            List<String> board = convert2board(stack, n);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !master.contains(row + i) && !slave.contains(row - i)) {
                stack.add(i);
                col.add(i);
                master.add(row + i);
                slave.add(row - i);

                backtrack(row + 1, stack);

                slave.remove(row - i);
                master.remove(row + i);
                col.remove(i);
                stack.pop();
            }
        }
    }

    private List<String> convert2board(Stack<Integer> stack, int n) {
        List<String> board = new ArrayList<>();
        for (Integer num : stack) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append(".");
            }
            stringBuilder.replace(num, num + 1, "Q");
            board.add(stringBuilder.toString());
        }
        return board;
    }

    public static void main(String[] args) {
        Test51 test = new Test51();
        List<List<String>> lists = test.solveNQueens(5);
        for (List<String> list : lists) {
            System.out.println(JSON.toJSONString(list));
        }
    }
}
