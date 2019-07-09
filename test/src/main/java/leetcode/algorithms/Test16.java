package leetcode.algorithms;

/**
 * @author huoxianwei
 * @date 2019/7/9 14:42
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 */
public class Test16 {
    /**
     * 超时版
     * @param array 数组
     * @return 结果
     */
    public static int test (int[] array, int target) {
        int temp = 2;
        int min = Math.abs(array[0] + array[1] + array[2] - target);
        int total = array[0] + array[1] + array[2];
        for (int i = 0; i < array.length-temp; i++) {
            for (int j = i+1; j < array.length-1; j++) {
                for (int k = j+1; k < array.length; k++) {
                    int sum = array[i] + array[j] + array[k];
                    int num = Math.abs(sum - target);
                    if (num < min) {
                        min = num;
                        total = sum;
                    }
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] num = {-1,1,2,-4};
        int target = 1;
        int test = test(num, target);
        System.out.println(test);
    }
}
