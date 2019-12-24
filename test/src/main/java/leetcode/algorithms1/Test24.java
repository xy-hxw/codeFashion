package leetcode.algorithms1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2019/7/12 16:37
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Test24 {

    /**
     * 暴力法
     * @param head head
     * @return 链表
     */
    public static ListNode test (ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (null != head) {
            list.add(head.val);
            head = head.next;
        }
        ListNode node = new ListNode(0);
        ListNode temp = node;
        if (list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return new ListNode(list.get(0));
        }
        if (list.size() % 2 == 1) {
            list.add(null);
        }
        for (int i = 0; i < list.size() - 1;) {
            ListNode node1 = new ListNode(list.get(i));
            if (null != list.get(i+1)) {
                ListNode node2 = new ListNode(list.get(i+1));
                temp.next = node2;
                node2.next = node1;
            } else {
                temp.next = node1;
            }
            temp = node1;
            i = i + 2;
        }
        return node.next;
    }

    public static ListNode test3 (ListNode head) {
        ListNode node = new ListNode(0);
        int i = 0;
        ListNode curr = node;
        ListNode temp = null;
        while (null != head) {
            i = i + 1;
            if (i % 2 == 1) {
                temp = head;
                head = head.next;
                temp.next = null;
            } else {
                curr.next = head;
                head = head.next;
                curr.next.next = temp;
                curr = temp;
                temp = null;

            }
        }
        if (null != temp && null != curr) {
            curr.next = temp;
        }
        return node.next;
    }

    /**
     * 递归
     * @param head head
     * @return 调转后链表
     */
    public static ListNode test1 (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = test1(next.next);
        next.next = head;
        return next;
    }

    /**
     * 循环
     * @param head head
     * @return 链表
     */
    public static ListNode test2 (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while (null != temp.next && null != temp.next.next) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            start.next = end.next;
            temp.next = end;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.node();
        ListNode test = test3(node);
        while (null != test) {
            System.out.println(test.val);
            test = test.next;
        }
    }
}
