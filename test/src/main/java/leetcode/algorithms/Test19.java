package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2019/7/9 17:41
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class Test19 {

    /**
     *
     * @param head 链表
     * @param n 倒数第n个节点
     * @return 链表
     */
    public static ListNode test (ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        while (null != head) {
            list.add(new ListNode(head.val));
            head = head.next;
        }
        if (list.size() == 1) {
            return null;
        }
        int m = list.size() - n;
        list.remove(m);
        ListNode listNode = new ListNode(list.get(0).val);
        ListNode next = listNode;
        for (int i = 1; i < list.size(); i++) {
            next.next = list.get(i);
            next = list.get(i);
        }
        return listNode;
    }

    /**
     * 双指针，指针间隔固定长度n
     * @param head 链表
     * @param n 倒数第n个数
     * @return 去除固定数后的链表
     */
    public static ListNode test1 (ListNode head, int n) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode first = listNode;
        ListNode second = listNode;
        for (int i = 1; i <= n+1; i++) {
            first = first.next;
        }
        while (null != first) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        test(node1, 2);
        test1(node1, 2);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
