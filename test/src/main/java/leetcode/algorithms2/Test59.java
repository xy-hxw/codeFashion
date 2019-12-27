package leetcode.algorithms2;

import com.alibaba.fastjson.JSON;

/**
 * @author huoxianwei
 * @date 2019/12/27 16:34
 *
 * 给定一个正整数 n，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵
 */
public class Test59 {

    private static int[][] generateMatrix(int n) {
        int[][] ints = new int[n][n];
        generage(ints, 0, n-1, 1);
        return ints;
    }

    private static void generage (int[][] ints, int start, int end, int num) {
        if (end < start) {
            return;
        }
        for (int i = start; i < end; i++) {
            ints[start][i] = num++;
        }
        for (int i = start; i < end; i++) {
            ints[i][end] = num++;
        }
        for (int i = end; i > start; i--) {
            ints[end][i] = num++;
        }
        for (int i = end; i > start; i--) {
            ints[i][start] = num++;
        }
        if (start == end) {
            ints[start][end] = num;
            start = start + 1;
            end = end + 1;
        }
        generage(ints, start+1, end-1, num);
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] ints = generateMatrix(n);
        for (int[] anInt : ints) {
            System.out.println(JSON.toJSONString(anInt));
        }
    }
}
