package leetcode.algorithms2;

import com.alibaba.fastjson.JSON;

/**
 * @author huoxianwei
 * @date 2020/1/2 9:49
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法
 */
public class Test73 {

    private static void setZeroes(int[][] matrix) {
        boolean isCol = false;
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int j = 0; j < c; j++) {
                matrix[0][j] = 0;
            }
        }
        if (isCol) {
            for (int i = 0; i < r; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = {0,1,2,0};
        int[] num2 = {3,4,5,2};
        int[] num3 = {1,3,1,5};
        int[][] nums = {num1, num2, num3};
        setZeroes(nums);
        for (int[] num : nums) {
            System.out.println(JSON.toJSONString(num));
        }
    }

}
