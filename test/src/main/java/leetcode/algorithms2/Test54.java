package leetcode.algorithms2;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2019/12/26 17:53
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class Test54 {

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (null != matrix && matrix.length != 0) {
            load(list, matrix, 0, matrix[0].length-1, 0, matrix.length-1);
        }
        return list;
    }

    private static void load (List<Integer> list, int[][] matrix, int startRow, int endRow, int startColumn, int endColumn) {
        if (startRow > endRow || startColumn > endColumn) {
            return;
        }
        for (int i = startRow; i <= endRow; i++) {
            list.add(matrix[startColumn][i]);
        }
        for (int i = startColumn+1; i <= endColumn; i++) {
            list.add(matrix[i][endRow]);
        }
        if (startColumn < endColumn) {
            for (int i = endRow-1; i >= startRow; i--) {
                list.add(matrix[endColumn][i]);
            }
        }
        if (startRow < endRow) {
            for (int i = endColumn-1; i >= startColumn+1; i--) {
                list.add(matrix[i][startRow]);
            }
        }
        load(list, matrix, startRow+1, endRow-1, startColumn+1, endColumn-1);
    }

    private static List<Integer> spiralOrder1(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0) {
            return ans;
        }
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,3};
        int[] num2 = {4,5,6};
        int[] num3 = {7,8,9};
        int[][] nums = {num1, num2, num3};
        List<Integer> list = spiralOrder1(nums);
        System.out.println(JSON.toJSONString(list));
    }
}
