package leetcode.algorithms2;

import java.util.Arrays;

/**
 * @author huoxianwei
 * @date 2019/12/30 10:19
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 */
public class Test62 {

    private static int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }


    public static void main(String[] args) {
        int m = 7, n =2 ;
        int i = uniquePaths(m, n);
        System.out.println(i);
    }
}
