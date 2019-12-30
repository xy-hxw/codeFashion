package leetcode.algorithms2;


/**
 * @author huoxianwei
 * @date 2019/12/27 18:18
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class Test61 {

    private static ListNode rotateRight(ListNode head, int k) {
        if (null == head || k == 0) {
            return head;
        }
        ListNode temp = head;
        int sum = 0;
        while (null != temp.next) {
            sum = sum + 1;
            temp = temp.next;
        }
        k = k % (sum+1);
        if (k == 0) {
            return head;
        }
        ListNode end = head;
        ListNode first;
        for (int i = 0; i < sum-k; i++) {
            end = end.next;
        }
        first = end.next;
        end.next = null;
        temp.next = head;
        return first;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode current = listNode;
        for (int i = 2; i <= 4; i++) {
            ListNode node = new ListNode(i);
            current.next = node;
            current = node;
        }
        ListNode node = rotateRight(listNode, 2);
        while (null != node) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
