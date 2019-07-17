package leetcode.algorithms;

/**
 * @author huoxianwei
 * @date 2019/7/15 18:47
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    static ListNode node() {
        ListNode node = new ListNode(1);
        ListNode current = node;
        for (int i = 1; i <= 10; i++) {
            ListNode listNode = new ListNode(i+1);
            current.next = listNode;
            current = listNode;
        }
        return node;
    }

    public static ListNode node (int k) {
        ListNode node = new ListNode(1);
        ListNode current = node;
        for (int i = 1; i <= k; i++) {
            ListNode listNode = new ListNode(i+1);
            current.next = listNode;
            current = listNode;
        }
        return node;
    }
}
