package leetcode.algorithms;

import java.util.Arrays;

/**
 * @author huoxianwei
 * @date 2019/12/23 17:19
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度
 */
public class Test48 {

    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n>>>1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {4,5,6};
        int[] nums3 = {7,8,9};
        int[][] matrix = new int[3][3];
        matrix[0] = nums1;
        matrix[1] = nums2;
        matrix[2] = nums3;
        rotate(matrix);
        for (int[] matrix1 : matrix) {
            System.out.println(Arrays.toString(matrix1));
        }
    }
}
