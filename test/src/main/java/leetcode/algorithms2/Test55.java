package leetcode.algorithms2;

/**
 * @author huoxianwei
 * @date 2019/12/27 9:11
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 */
public class Test55 {

    private static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    private static boolean canJump1 (int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        for (int i = nums.length-1-1; i > 0; i--) {
            if (nums[i] == 0) {
                for (int j = i; j > 0; j--) {
                    if (nums[j] > (i - j)) {
                        break;
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,1,0,4};
        boolean b = canJump(nums);
        System.out.println(b);
        boolean b1 = canJump1(nums);
        System.out.println(b1);
    }
}
