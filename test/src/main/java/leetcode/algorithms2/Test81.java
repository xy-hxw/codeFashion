package leetcode.algorithms2;

/**
 * @author huoxianwei
 * @date 2020/1/7 17:48
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 */
public class Test81 {

    private static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<right) {
            if (nums[left] < target) {
                left++;
            } else if (nums[right] > target) {
                right--;
            } else {
                return nums[left] == target || nums[right] == target;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,6};
        int target = -1;
        boolean search = search(nums, target);
        System.out.println(search);
    }

}
