package common.algorithm.sorting;

import java.util.Arrays;

/**
 * 计数排序
 * @author huoxianwei
 * @date 2019/2/15 17:04
 * 适用于一组数 最大数和最小数差不大的数组排序
 */
public class AlgorithmUtil {
	/**
	 * 计数排序
	 * @param array 数组
	 * @return 排序后数组
	 * 循环两次
	 * 		1：找出最大值，最小值
	 * 		2：最终排序
	 */
	private static int[] countSort(int[] array) {
		// 找到最大数和最小数
		int max = array[0];
		int min = array[0];
		for (int i : array) {
			if (i > max) {
				max = i;
			}
			if (i < min) {
				min = i;
			}
		}
		int d = max - min;

		// 数组中每个数减去最小数差值即为每个数排序位置，如果有多个数相同则加 1
		// 创建统计数组统计对应元素个数
		// [2, 2, 0, 1, 1, 1, 0, 0, 1, 2]
		int[] countArray = new int[d+1];
		for (int i : array) {
			countArray[i - min]++;
		}
		System.out.println("每个位置元素的个数="+Arrays.toString(countArray));

		// 统计数组做变形，每一个位置值等于前面所有值之和
		// 在最后数组排序时，每个位置的数字即表示该数字所在的位置
		// 数字相同，后来的比之前的大 1，位置靠后了一位，所以保证了所有数字的有序性排序
		// [2, 4, 4, 5, 6, 7, 7, 7, 8, 10]
		int sum = 0;
		for (int i = 0; i < countArray.length; i++) {
			sum += countArray[i];
			countArray[i] = sum;
		}
		System.out.println("变形后数组="+Arrays.toString(countArray));
		// 倒序遍历数组，从统计数组开始找到正确位置，输出到结果数组

		// 数组倒叙循环
		// 		每一个数所在的位置即为这个数减去最小数的差值再减一(数组下标从零开始，有数字标记的是1)
		// 		对应的countArray中位置的值
		int[] sortedArray = new int[array.length];
		System.out.println("min="+min+"  max="+max);
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
