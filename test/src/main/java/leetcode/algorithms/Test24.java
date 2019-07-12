package leetcode.algorithms;

/**
 * @author huoxianwei
 * @date 2019/7/12 16:37
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Test24 {

    public static ListNode test (ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = test(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode test = test(n1);
        while (null != test) {
            System.out.println(test.val);
            test = test.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
