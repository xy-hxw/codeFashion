package common.algorithm.sorting;

import com.alibaba.fastjson.JSON;

/**
 * 插入排序
 * @author huoxianwei
 * @date 2019/4/23 16:11
 */
public class Insertion {
    /**
     * 排序
     * @param array 无序数组
     * @return 有序数组
     */
    private static int[] sort(int[] array) {
        if (null == array || array.length<=1) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            // 每次比较的基准数
            int temp = array[i];
            int j;
            for (j=i; j>0&&array[j-1]>temp; j--) {
                array[j] = array[j-1];
            }
            array[j] = temp;
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array = {5,6,4,1,8,3};
        int[] sort = sort(array);
        System.out.println(JSON.toJSONString(sort));
    }
}
