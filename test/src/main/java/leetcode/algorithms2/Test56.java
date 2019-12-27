package leetcode.algorithms2;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2019/12/27 9:39
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 */
public class Test56 {

    private static int[][] merge(int[][] intervals) {
        if (null == intervals || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            } else {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
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
        int[] num1 = {1,4};
        int[] num2 = {2,3};
        int[][] nums = {num1, num2};
        int[][] merge = merge(nums);
        System.out.println(JSON.toJSONString(merge));
    }
}
