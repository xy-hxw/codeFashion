package leetcode.algorithms2;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2020/1/3 9:19
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
 */
public class Test78 {

    private static List<List<Integer>> enumerate (int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) {
                    sub.add(nums[j]);
                }
            }
            res.add(sub);
        }
        return res;
    }

    /**
     * 循环枚举
     */
    private static List<List<Integer>> enumerate1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (Integer n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = enumerate1 (nums);
        for (List<Integer> list1 : list) {
            System.out.println(JSON.toJSONString(list1));
        }
    }
}
