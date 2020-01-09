package leetcode.algorithms2;

/**
 * @author huoxianwei
 * @date 2020/1/9 17:17
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class Test83 {

    private static ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode first = head;
        ListNode current = head.next;
        while (null != current) {
            if (first.val == current.val) {
                first.next = current.next;
            } else {
                first = current;
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3};
        ListNode node1 = deleteDuplicates(ListNode.create(nums));
        while (null != node1) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }
}
