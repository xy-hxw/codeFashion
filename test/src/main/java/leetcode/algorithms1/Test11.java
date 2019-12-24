package leetcode.algorithms1;

/**
 * @author huoxianwei
 * @date 2019/7/5 16:47
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 */
public class Test11 {

    public static int test (int[] array) {
        int max = 0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                int width = j - i;
                int height = Math.min(array[i], array[j]);
                max = Math.max(width * height, max);
            }
        }
        return max;
    }

    public static int test1 (int[] array) {
        int max = 0;
        int i = 0, length = array.length - 1;
        while (i < length) {
            int height = Math.min(array[i], array[length]);
            max = Math.max(max, (length-i)*height);
            if (array[i] < array[length]) {
                i++;
            } else {
                length--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1,8,6,2,5,4,8,3,7};
        int test = test(array);
        System.out.println(test);
        int i = test1(array);
        System.out.println(i);
    }
}
