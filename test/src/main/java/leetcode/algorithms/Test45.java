package leetcode.algorithms;

/**
 * @author huoxianwei
 * @date 2019/12/19 16:26
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 */
public class Test45 {
    private static int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length-1; i++) {
            maxPosition = Math.max(maxPosition, i+nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = {5,5,6,3,1};
        int jump = jump(nums);
        System.out.println(jump);
    }
}
