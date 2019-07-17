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

        ListNode node = ListNode.node();
        test(node, 2);
        test1(node, 2);
    }
}
