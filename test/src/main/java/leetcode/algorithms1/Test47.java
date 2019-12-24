package leetcode.algorithms1;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2019/12/23 16:45
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class Test47 {

    private static List<List<Integer>> permuteUnique (int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        Arrays.sort(nums);
        upset(nums, 0, all);
        return all;
    }

    private static void upset(int[] nums, int begin, List<List<Integer>> all) {
        if (begin == nums.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            all.add(new ArrayList<>(temp));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = begin; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            swap(nums, i, begin);
            upset(nums, begin + 1, all);
            swap(nums, i, begin);
        }

    }

    private static void swap(int[] nums, int i, int begin) {
        int temp = nums[i];
        nums[i] = nums[begin];
        nums[begin] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> lists = permuteUnique(nums);
        for (List<Integer> list: lists) {
            System.out.println(JSON.toJSONString(list));
        }
    }
}
