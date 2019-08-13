package leetcode.algorithms;

import com.alibaba.fastjson.JSON;

/**
 * @author huoxianwei
 * @date 2019/7/18 9:12
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class Test26 {

    public static int test (int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j=1;j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i = i + 1;
                nums[i] = nums[j];
            }
        }
        System.out.println(JSON.toJSONString(nums));
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        int test = test(nums);
        System.out.println(test);
    }
}
