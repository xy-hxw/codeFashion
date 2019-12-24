package leetcode.algorithms1;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * @author huoxianwei
 * @date 2019/12/13 17:03
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Test42 {
    /**
     * 双指针
     * @param height 数组
     * @return 积水深度
     */
    private static int trap(int[] height) {
        int sum = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int left = 1;
        int right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                maxLeft = Math.max(maxLeft, height[left - 1]);
                int min = maxLeft;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                maxRight = Math.max(maxRight, height[right + 1]);
                int min = maxRight;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }

    /**
     * 动态规划
     * @param height height
     * @return 水量
     */
    private static int trap1(int[] height) {
        int sum = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        System.out.println(JSON.toJSONString(maxLeft));
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        System.out.println(JSON.toJSONString(maxRight));
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public static int trap2 (int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                //取出要出栈的元素
                int h = height[stack.peek()];
                stack.pop();
                // 栈空就出去
                if (stack.empty()) {
                    break;
                }
                //两堵墙之前的距离。
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            //当前指向的墙入栈
            stack.push(current);
            //指针后移
            current++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0,5,0,2,1,0,1,3,2,1,2,1};
        int trap = trap2(height);
        System.out.println(trap);
    }
}
