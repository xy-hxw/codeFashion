package leetcode.algorithms2;

import java.util.Arrays;

/**
 * @author huoxianwei
 * @date 2020/1/10 10:27
 *
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积
 */
public class Test85 {

    private static int maximalRectangle (char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int maxarea = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == '1'){
                    // compute the maximum width and update dp with it
                    dp[i][j] = j == 0? 1 : dp[i][j-1] + 1;
                    int width = dp[i][j];
                    // compute the maximum area rectangle with a lower right corner at [i, j]
                    for(int k = i; k >= 0; k--){
                        width = Math.min(width, dp[k][j]);
                        maxarea = Math.max(maxarea, width * (i - k + 1));
                    }
                }
            }
        } return maxarea;
    }

    private static int maximalRectangle1 (char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n);
        int maxarea = 0;
        for (char[] matrix1 : matrix) {
            int curLeft = 0, curRight = n;
            // update height
            for (int j = 0; j < n; j++) {
                if (matrix1[j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            // update left
            for (int j = 0; j < n; j++) {
                if (matrix1[j] == '1') {
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            // update right
            for (int j = n - 1; j >= 0; j--) {
                if (matrix1[j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = n;
                    curRight = j;
                }
            }
            // update area
            for (int j = 0; j < n; j++) {
                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxarea;
    }

    public static void main(String[] args) {
        char[][] nums = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int i = maximalRectangle(nums);
        System.out.println(i);
        int i1 = maximalRectangle1(nums);
        System.out.println(i1);
    }
}
