package leetcode.algorithms2;

/**
 * @author huoxianwei
 * @date 2019/12/27 18:19
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static ListNode create (int[] nums) {
        ListNode first = new ListNode(nums[0]);
        ListNode current = first;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            current.next = node;
            current = node;
        }
        return first;
    }
}
