package common.algorithm.sorting;

import com.alibaba.fastjson.JSON;

/**
 * @author huoxianwei
 * @date 2019/2/20 18:04
 * 快速排序
 *      找一个基准数，从数组两边分别进行对比，小数放左边，大数放右边。左右依次进行递归，最终得到有序数组
 */
public class QuickSort {

    public static int[] test (int[] array) {
        if (null == array || array.length == 0) {
            return array;
        }
        int min = 0;
        order(min, array.length-1, array);
        return array;
    }

    private static void order (int start, int end, int[] array) {
        if (null == array || array.length == 0 || start >= end) {
            return;
        }
        int min = start;
        int max = end;
        int first = array[min];
        while (min < max) {
            // 从右边找到小于基准数的第一个数
            while (min < max && array[max] > first) {
                max--;
            }
            // 从左边找到大于等于基准数的第一个数
            while (min < max && array[min] <= first) {
                min++;
            }
            // 交换
            if (min < max) {
                int temp = array[min];
                array[min] = array[max];
                array[max] = temp;
            }
        }

        first = array[min];
        array[min] = array[start];
        array[start] = first;
        System.out.println("排序后="+start+" "+" "+end + " "+ min+"  "+max+"  "+ JSON.toJSONString(array));
        order(start, min - 1, array);
        order(max + 1, end, array);
    }

    public static void main(String[] args) {
        int[] array = {5,9,5,6,2,7};
        int[] test = test(array);
        System.out.println(JSON.toJSONString(test));
    }
}
