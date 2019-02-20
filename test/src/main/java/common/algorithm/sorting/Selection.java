package common.algorithm.sorting;

import com.alibaba.fastjson.JSON;

/**
 * @author huoxianwei
 * @date 2019/2/20 17:14
 *  选择排序
 *      时间复杂度 O(n²)
 *      优点：不占用额外内存，最稳定的算法
 */
public class Selection {

    private static int[] test (int[] array) {
        if (null == array || array.length == 0) {
            return array;
        }
        // 每循环一次找出循环的数中最小的数，将此数放置在循环开始位置
        for (int i = 0; i < array.length; i++) {
            // 找出数组中最小的数
            int k = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[k]) {
                    k = j;
                }
            }
            // 将最小的数放置此次循环的开始
            if (i != k) {
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {5,9,6,4,2,7};
        int[] test = test(array);
        System.out.println(JSON.toJSONString(test));
    }
}
