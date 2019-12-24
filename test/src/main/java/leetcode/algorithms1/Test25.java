package leetcode.algorithms1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2019/7/15 18:40
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 说明 :
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Test25 {

    /**
     * 暴力法
     * @param head head
     * @param k 节点个数
     * @return 处理后ListNode
     */
    public static ListNode test (ListNode head, int k) {
        List<List<ListNode>> lists = new ArrayList<>();
        int index = 0;
        List<ListNode> list = null;
        while (null != head) {
            if (0 == index) {
                list = new ArrayList<>();
            }
            index = index + 1;
            if (index <= k) {
                ListNode node = head;
                head = head.next;
                node.next = null;
                list.add(node);
            }
            if (index == k) {
                lists.add(list);
                index = 0;
            }
        }
        if (null != list && list.size() > 0) {
            lists.add(list);
        }
        ListNode listNode = new ListNode(0);
        ListNode current = listNode;
        for (List<ListNode> temp : lists) {
            if (temp.size() >= k) {
                for (int i = temp.size() - 1; i >= 0; i--) {
                    current.next = temp.get(i);
                    current = temp.get(i);
                }
            } else {
                for (ListNode node : temp) {
                    current.next = node;
                    current = node;
                }
            }
        }
        return listNode.next;
    }

    /**
     * 每K个节点存储一次，遍历反转
     * @param head head
     * @param k 节点数
     * @return 反转后节点
     */
    public static ListNode test1 (ListNode head, int k) {
        ListNode listNode = new ListNode(0);
        ListNode pre = listNode;
        int index = 0;
        List<ListNode> list = new ArrayList<>();
        while (null != head) {
            index = index + 1;
            ListNode temp = head;
            list.add(temp);
            head = head.next;
            temp.next = null;
            if (index == k) {
                while (!list.isEmpty()) {
                    ListNode peek = list.remove(list.size() -1);
                    pre.next = peek;
                    pre = peek;
                }
                index = 0;
            }
        }
        if (!list.isEmpty()) {
            for (ListNode listNode1 : list) {
                pre.next = listNode1;
                pre = listNode1;
            }
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.node(10);
        ListNode test = test1(node,3);
        while (null != test) {
            System.out.println(test.val);
            test = test.next;
        }
    }

}
