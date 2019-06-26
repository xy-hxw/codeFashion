package common.algorithm.sorting;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2019/5/9 17:59
 * 基数排序
 * 按照个位、十位、百位依次进行排序
 */
public class RadixSort {

    public static int[] test (int[] array) {
        if (null == array || array.length == 0) {
            return null;
        }
        int max = max(array);
        int length = String.valueOf(max).length();
        int num = 10;
        List<List<Integer>> list = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < length; i++) {
            array = sort(array, i, list);
        }
        return array;
    }

    private static int max (int[] array) {
        int max = 0;
        for (int i1 : array) {
            if (i1 >= max) {
                max = i1;
            }
        }
        return max;
    }

    private static int[] sort(int[] array, int num, List<List<Integer>> list) {
        for (int i1 : array) {
            int a = i1 / ((int) Math.pow(10, num)) % 10;
            List<Integer> rlist = list.get(a);
            rlist.add(i1);
        }
        array = new int[array.length];
        int size = 0;
        for (List<Integer> ints : list) {
            if (CollectionUtils.isNotEmpty(ints)) {
                for (Integer anInt : ints) {
                    array[size] = anInt;
                    size = size + 1;
                }
            }
            ints.clear();
        }
        System.out.println(JSON.toJSONString(array));
        return array;
    }

    public static void main(String[] args) {
        int[] a = {125, 458, 1, 65, 1496, 784, 65};
        int[] test = test(a);
        System.out.println(JSON.toJSONString(test));
    }
}
