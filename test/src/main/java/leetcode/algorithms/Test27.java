package leetcode.algorithms;

import com.alibaba.fastjson.JSON;

/**
 * @author huoxianwei
 * @date 2019/8/13 14:44
 *
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class Test27 {
    public static int test (int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (val != nums[j]) {
                nums[i] = nums[j];
                i = i + 1;
            }
        }
        System.out.println(JSON.toJSONString(nums));
        return i;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int test = test(nums, val);
        System.out.println(test);
    }
}
