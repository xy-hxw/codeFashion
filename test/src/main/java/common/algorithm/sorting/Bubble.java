package common.algorithm.sorting;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author huoxianwei
 * @Date 2018/12/19 10:58
 * @Description 冒泡排序
 */
public class Bubble {
    /**
     *  获取一组随机数
      */
    public static Integer[] test(Integer num) {
        if (num <= 0) {
            num = 10;
        }
        Integer[] array = new Integer[num];
        for (int i = 0; i < num; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(10*num);
        }
        return array;
    }
    /**
     * 冒泡排序法一
     * 时间复杂度：O(n^2)
     * 排序次数为 n(n-1)/2
     */
    public static void test1(Integer[] array) {
        int sum = 0;
        if (null != array) {
            int temp;
            int length = array.length;
            // 需要比较的次数
            for (int i = 0; i < length; i++) {
                // 每一次比较相邻的两个数，把较小的往后挪动
                for (int j = 0; j < length-1-i; j++) {
                    if (array[j] < array[j+1]) {
                        // 将两个数中较小的数挪动到右边
                        temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                    sum = sum + 1;
                }
            }
        }
        System.out.println("循环次数="+sum);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序法二
     * 每一轮比较时如果没有交换过，则数组已经有序
     * 每一轮比较时如果从index位置开始没有交换过，则index后面的已经有序，下一轮比较到index-1位置即可
     */
    private static void test2(Integer[] array) {
        int sum = 0;
        if (null != array) {
            int length = array.length;
            // 交换位置时临时存储
            int temp;
            // 每一次交换位置时索引
            int index = length - 1;
            // 需要比较的次数
            for (int i = 0; i < length; i++) {
                // 记录每一轮中是否有交换
                boolean b = true;
                int max = 0;
                for (int j = 0; j < index; j++) {
                    if (array[j] < array[j+1]) {
                        temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                        b = false;
                        max = j;
                    }
                    sum = sum + 1;
                }
                index = max;
                if (b) {
                    break;
                }
            }
        }
        System.out.println("循环次数="+sum);
        System.out.println(Arrays.toString(array));
    }
    public static void main(String[] args) {
        Integer[] array1 = test(10);
        Integer[] array2 = array1.clone();
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        test1(array1);
        test2(array2);
    }
}
