package leetcode.algorithms2;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2019/12/27 10:30
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class Test57 {

    private static int[][] insert(int[][] intervals, int[] newInterval) {
        if (null == intervals || intervals.length == 0) {
            return new int[][]{newInterval};
        } else if (null == newInterval || newInterval.length == 0) {
            return intervals;
        }
        int start = newInterval[0];
        int end = newInterval[1];
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (end < interval[0]) {
                list.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            } else if (interval[0] <= start && start <= interval[1]) {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            } else if (interval[0] <= end && end <= interval[1]) {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            } else if (start > interval[1]) {
                list.add(interval);
            }
        }
        list.add(new int[]{start, end});
        int[][] ints = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {6,9};
        int[][] nums = {nums1, nums2};
        int[] nums6 = {2,5};
        int[][] insert = insert(nums, nums6);
        System.out.println(JSON.toJSONString(insert));
    }
}
