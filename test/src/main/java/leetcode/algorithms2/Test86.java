package leetcode.algorithms2;

/**
 * @author huoxianwei
 * @date 2020/1/13 16:23
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 */
public class Test86 {

    private static ListNode partition(ListNode head, int x) {
        ListNode samll = new ListNode(-1);
        ListNode first = samll;
        ListNode large = new ListNode(-1);
        ListNode current = large;
        while (null != head) {
            if (head.val < x) {
                first.next = head;
                first = first.next;
            } else {
                current.next = head;
                current = current.next;
            }
            head= head.next;
        }
        current.next = null;
        first.next = large.next;
        return samll.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,2,5,1,6};
        int n = 3;
        ListNode node = partition(ListNode.create(nums), n);
        while (null != node) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
