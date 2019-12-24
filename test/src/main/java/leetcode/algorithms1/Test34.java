package leetcode.algorithms1;

import com.alibaba.fastjson.JSON;

/**
 * @author huoxianwei
 * @date 2019/10/30 15:35
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */
public class Test34 {
    private static int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        if (null == nums || nums.length == 0 || target < nums[0] || target > nums[nums.length-1]) {
            return range;
        }
        int left = 0;
        int right = nums.length;
        // 找最小值
        while (left < right) {
            int mid = (left + right)/2;
            System.out.println("left="+left+"  right="+right+"  mid="+mid);
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] != target) {
            return range;
        }
        range[0] = left;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            System.out.println("left="+left+"  right="+right+"  mid="+mid);
            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        range[1] = left - 1;
        return range;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,8,8,8,10};
        int target = 6;
        int[] ints = searchRange(nums, target);
        System.out.println(JSON.toJSONString(ints));
    }
}
