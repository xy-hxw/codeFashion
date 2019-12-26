package leetcode.algorithms2;

/**
 * @author huoxianwei
 * @date 2019/12/26 17:39
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Test53 {

    private static int maxSubArray(int[] nums) {
        int max = nums[0];
        int current = nums[0];
        for (int num : nums) {
            current = Math.max(num, current + num);
            max = Math.max(max, current);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }
}
