package common;

import java.util.Arrays;

public class AlgorithmUtil {
	/**
	 * 计数排序
	 * @param array
	 * @return
	 */
	public static int[] countSort(int[] array) {
		int max = array[0];
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if(array[i]>max) {
				max = array[i];
			}
			if(array[i]<min) {
				min = array[i];
			}
		}
		int d = max - min;
		//创建统计数组统计对应元素个数
		int[] countArray = new int[d+1];
		for (int i = 0; i < array.length; i++) {
			countArray[array[i]-min]++;
		}
		System.out.println(Arrays.toString(countArray));
		//统计数组做变形，后面元素等于前面元素之和
		int sum = 0;
		for (int i = 0; i < countArray.length; i++) {
			sum += countArray[i];
			countArray[i] = sum;
		}
		//倒序遍历数组，从统计数组开始找到正确位置，输出到结果数组
		int[] sortedArray = new int[array.length];
		for (int i = array.length-1; i >=0; i--) {
			sortedArray[countArray[array[i]-min]-1]=array[i];
			System.out.print(i+"----"+array[i]+"------"+countArray[array[i]-min]);
			countArray[array[i]-min]--;
			System.out.println("------"+countArray[array[i]-min]);
		}
		return sortedArray;
	}
	public static void main(String[] args) {
		int[] array = new int[] {95,94,91,98,99,90,99,93,91,90};
		int[] countSort = countSort(array);
		System.out.println(Arrays.toString(countSort));
	}
}
