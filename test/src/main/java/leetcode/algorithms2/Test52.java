package leetcode.algorithms2;

/**
 * @author huoxianwei
 * @date 2019/12/24 17:43
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击
 */
public class Test52 {

    private static int count = 0;

    private static int totalNQueens(int n) {
        // 从0开始遍历就行了，dfs会自动遍历所有可能方案
        dfs(0, 0, 0, 0, n);
        return count;
    }

    private static void dfs(int row, int qCol, int larger, int smaller, int n) {
        if (row >= n) {
            count++;
        }

        int bits = (~(qCol | larger | smaller)) & ((1 << n) - 1);
        while (bits != 0) {
            // 获取最低位,尝试遍历，失败则回溯
            int tryBit = bits & -bits;
            dfs(row + 1, qCol | tryBit,(larger | tryBit) << 1,(smaller | tryBit) >> 1, n);
            // 删除最低位,尝试下一个候选cur
            bits &= bits - 1;
        }
    }

    public static void main(String[] args) {
        int num = 4;
        int i = totalNQueens(num);
        System.out.println(i);
        int b = ~0;
        System.out.println(b);
    }
}
