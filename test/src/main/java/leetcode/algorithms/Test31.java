package leetcode.algorithms;

import com.alibaba.fastjson.JSON;

/**
 * @author huoxianwei
 * @date 2019/10/14 14:14
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 1,2,3 → [1,2,3]、[1,3,2]、[2,1,3]、[2,3,1]、[3,1,2]、[3,2,1]
 * 最小排序[1,2,3]，最大排序[3,2,1]
 * （1）从右往左找到第一个比上一个小的数i，将此数i和由此第一个比他小的数进行交换
 * （2）因为i右侧的数列为有序（倒序），将i右侧数列反转即可
 *
 */
public class Test31 {
    private static void nextPermutation (int[] nums) {
        int i = nums.length-2;
        while (i>=0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i>=0) {
            int j = nums.length-1;
            while (j>=0 && nums[j] <= nums[i]) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int k = i+1;
        int m = nums.length-1;
        while (k < m) {
            int temp1 = nums[k];
            nums[k] = nums[m];
            nums[m] = temp1;
            k++;
            m--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1};
        nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
