package leetcode.algorithms2;

/**
 * @author huoxianwei
 * @date 2020/1/7 17:18
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class Test80 {

    private static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[k] == nums[i]) {
                if (i-k >= 2) {
                    n--;
                    k=k+1;
                }
            } else {
                k = i;
            }
        }
        return n;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }
}
