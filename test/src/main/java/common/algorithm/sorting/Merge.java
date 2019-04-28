package common.algorithm.sorting;

import java.util.Arrays;

/**
 * 归并排序
 * @author huoxianwei
 * @date 2019/4/26 14:43
 */
public class Merge {
    public static void mergeSort (int[] array) {
        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
    public static void mergeSort (int[] array, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (right + left) >> 1;
            mergeSort(array, temp, left, mid);
            mergeSort(array, temp, mid+1, right);
            merge(array, temp, left, mid+1,right);
        }
    }
    public static void merge (int[] array, int[] temp, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos-1;
        System.out.println(Arrays.toString(array)+"  leftPos="+leftPos+"  leftEnd="+leftEnd+"  rightPos="+rightPos+"  rightEnd="+rightEnd);
        int temPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos] <= array[rightPos]) {
                temp[temPos++] = array[rightPos++];
            } else {
                temp[temPos++] = array[leftPos++];
            }
        }
        while (leftPos <= leftEnd) {
            temp[temPos++] = array[leftPos++];
        }
        while (rightPos <= rightEnd) {
            temp[temPos++] = array[rightPos++];
        }
        System.out.println(Arrays.toString(temp)+"  numElements="+numElements+"  rightEnd="+rightEnd+"  "+Arrays.toString(array));
        for (int i = 0; i < numElements; i++, rightEnd--) {
            System.out.println(rightEnd);
            array[rightEnd] = temp[rightEnd];
        }
//        System.out.println(Arrays.toString(temp)+"  numElements="+numElements+"  rightEnd="+rightEnd+"  "+Arrays.toString(array));
    }
    public static void main(String[] args) {
        int[] array = {5,9,6,4,1,8,3,6};
        mergeSort(array);
    }
}
