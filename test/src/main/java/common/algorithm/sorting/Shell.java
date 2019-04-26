package common.algorithm.sorting;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 希尔排序
 * @author huoxianwei
 * @date 2019/4/23 18:27
 * 对数组分组，每个组进行插入排序  递归
 */
@Slf4j
public class Shell {
    /**
     * 希尔排序
     * @param arr 无序数组
     * @return 有序数组
     */
    private static int[] shellSort(int[] arr){
        int i,j;
        int temp;
        int eleNum = arr.length;
        // 先求出h
        int h = 1;
        while(h < eleNum / 3) {
            h = 3 * h + 1;
        }
        // h进行分组
        while (h > 0) {
            log.info("h="+h);
            // 每次增加固定步长
            for(i = h ; i < eleNum ; i = i + h) {
                // 对子数组进行排序
                temp = arr[i];
                j = i;
                // 增加步长后和左侧的数据依次进行比较交换
                while(j > h-1 && temp <= arr[j-h]) {
                    System.out.println("j="+j+"  h-1="+(h-1)+"  temp="+temp+"  arr[j-h]="+(arr[j-h]));
                    System.out.println(Arrays.toString(arr));
                    arr[j] = arr[j-h];
                    j-=h;
                }
                arr[j] = temp;
            }
            h = (h-1)/3;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] array = {5,6,4,1,8,3};
        int[] ints = shellSort(array);
        System.out.println(Arrays.toString(ints));
    }
}
