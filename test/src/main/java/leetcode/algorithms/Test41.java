package leetcode.algorithms;

/**
 * @author huoxianwei
 * @date 2019/12/11 19:53
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 */
public class Test41 {
    private static int firstMissingPositive(int[] nums) {
        int num = nums.length+1;
        int[] temp = new int[num];
        for (int i = 0; i < num; i++) {
            temp[i] = i+1;
        }
        for (int num1 : nums) {
            if (num1 <= 0 || num1 > num) {
                continue;
            }
            temp[num1 - 1] = 0;
        }
        for (int i1 : temp) {
            if (i1 > 0) {
                return i1;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        int i = firstMissingPositive(nums);
        System.out.println(i);
    }
}
