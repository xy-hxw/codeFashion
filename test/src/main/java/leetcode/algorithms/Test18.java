package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2019/7/9 16:38
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 */
public class Test18 {

    public static List<List<Integer>> test (int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    boolean b = left != j + 1 && nums[left] == nums[left - 1];
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    boolean b1 = right != nums.length - 1 && nums[right] == nums[right + 1];
                    if (b || sum < target) {
                        left++;
                    } else if (b1 || sum > target) {
                        right--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);

                        result.add(list);
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> test = test(array, target);
        System.out.println(test);
    }
}
