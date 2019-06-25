package leetcode.algorithms;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author huoxianwei
 * @date 2019/6/24 11:29
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class Test1 {

    /**
     * 数组中所有值都不重复
     * @param nums 数组
     * @param target 目标值
     * @return 下标数组
     *
     * 时间复杂度 O(n²)
     */
    public static List<int[]> test (int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        List<int[]> list = Lists.newArrayList();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if ((nums[i] + nums[j]) == target) {
                    list.add(new int[]{i, j});
                }
            }
        }
        return list;
    }

    /**
     * 数组中所有值都不重复
     * @param nums 数组
     * @param target 目标值
     * @return 下标数组
     *
     * 时间复杂度 O(n)
     */
    private static List<int[]> fine(int[] nums, int target) {
        List<int[]> list = Lists.newArrayList();
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], i);
            if (null != map.get(target-nums[i])) {
                list.add(new int[]{map.get(target-nums[i]), i});
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, -2, -6};
        int target = 9;
        List<int[]> list = test(nums, target);
        System.out.println(JSON.toJSONString(list));
        List<int[]> fine = fine(nums, target);
        System.out.println(JSON.toJSONString(fine));
    }
}
