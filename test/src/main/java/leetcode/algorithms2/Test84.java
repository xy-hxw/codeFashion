package leetcode.algorithms2;

import java.util.Stack;

/**
 * @author huoxianwei
 * @date 2020/1/9 17:32
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积
 */
public class Test84 {

    private static int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                max = Math.max(max, min * (j-i+1));
            }
        }
        return max;
    }

    private static int largestRectangleArea1 (int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                maxArea = Math.max(heights[stack.pop()] * (i - stack.peek() - 1), maxArea);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(heights[stack.pop()] * (heights.length - stack.peek() - 1), maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heigths = {6,7,5,2,4,5,9,3};
        int i = largestRectangleArea1(heigths);
        System.out.println(i);
    }
}
