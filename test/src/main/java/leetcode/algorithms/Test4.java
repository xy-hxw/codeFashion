package leetcode.algorithms;

/**
 * @author huoxianwei
 * @date 2019/6/26 11:12
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 假设 nums1 和 nums2 不会同时为空。
 *
 * 解法：
 *      两个数字的中位数分别为i和j,则数组可以分为左右两部分
 *      偶数：i+j=m-i+n-j  奇数：i + j = m - i + n - j + 1  则：j = ( m + n + 1) / 2 - i
 *      因为 i减小的同时j增大，所有可以保证两部分的数字量相等
 *      最终达到：Math.max(a[i-1], b[j-1])<=Math.max(a[i], b[j])
 *
 */
public class Test4 {

    public static double test (int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        if (m > n) {
            return test(b, a);
        }
        int iMin = 0, iMax = m, halfLen = (m+n+1)/2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i<iMax && b[j-1]>a[i]) {
                iMin = i + 1;
            } else if (i>iMin && a[i-1]>b[j]) {
                iMax = i - 1;
            } else {
                int maxLeft;
                if (i == 0) {
                    maxLeft = b[j-1];
                } else if (j == 0) {
                    maxLeft = a[i-1];
                } else {
                    maxLeft = Math.max(a[i-1], b[j-1]);
                }
                if ((m+n)%2==1) {
                    return maxLeft;
                }
                int minRight;
                if (i==m) {
                    minRight = b[j];
                } else if (j==n) {
                    minRight = a[i];
                } else {
                    minRight = Math.max(a[i], b[j]);
                }
                return (maxLeft + minRight)/2.0;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double test = test(nums1, nums2);
        System.out.println(test);
    }
}
