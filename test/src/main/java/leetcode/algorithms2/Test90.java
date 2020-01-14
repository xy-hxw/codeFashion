package leetcode.algorithms2;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2020/1/14 10:52
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 */
public class Test90 {

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        merge(nums, 0, new ArrayList<>(), lists);
        return lists;
    }

    private static void merge (int[] nums, int start, ArrayList<Integer> list, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i>start && nums[i]==nums[i-1]) {
                continue;
            }
            list.add(nums[i]);
            merge(nums, i+1, list, lists);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> list = subsetsWithDup(nums);
        for (List<Integer> list1 : list) {
            System.out.println(JSON.toJSONString(list1));
        }
    }
}
