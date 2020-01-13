package leetcode.algorithms2;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author huoxianwei
 * @date 2020/1/13 19:36
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 */
public class Test88 {

    private static void merge (int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    private static void merge1 (int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1;
        int second = n - 1;
        int size = m + n - 1;
        while (first>=0 && second>=0) {
            if (nums2[second] >= nums1[first]) {
                nums1[size] = nums2[second];
                second = second - 1;
            } else {
                nums1[size] = nums1[first];
                first = first -1;
            }
            size = size-1;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(JSON.toJSONString(nums1));

        int[] nums3 = {1,2,3,0,0,0};
        int[] nums4 = {2,5,6};
        merge1(nums3, m, nums4, n);
        System.out.println(JSON.toJSONString(nums1));
    }
}
