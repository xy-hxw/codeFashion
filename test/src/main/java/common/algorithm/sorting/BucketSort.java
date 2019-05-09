package common.algorithm.sorting;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2019/5/9 17:27
 * 桶排序
 */
public class BucketSort {
    private static void bucketSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i1 : arr) {
            max = Math.max(max, i1);
            min = Math.min(min, i1);
        }
        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        System.out.println("max="+max+" min="+min+" bucketNum="+bucketNum);
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<>());
        }
        //将每个元素放入桶
        for (int i1 : arr) {
            int num = (i1 - min) / (arr.length);
            bucketArr.get(num).add(i1);
        }
        //对每个桶进行排序
        List<Integer> rlist = Lists.newArrayList();
        for (ArrayList<Integer> integers : bucketArr) {
            Collections.sort(integers);
            rlist.addAll(integers);
        }
        System.out.println(rlist);
    }
    public static void main(String[] args) {
        int[] array = new int[] {11,26,91,82,59,74,66,35,47,95};
        bucketSort(array);
    }
}
