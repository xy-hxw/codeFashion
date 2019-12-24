package leetcode.algorithms1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2019/7/10 20:25
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 */
public class Test21 {

    public static ListNode test (ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        while (null != l1 || null != l2) {
            if (null != l1) {
                list.add(l1.val);
                l1 = l1.next;
            }
            if (null != l2) {
                list.add(l2.val);
                l2 = l2.next;
            }
        }
        if (list.size() == 0) {
            return null;
        }
        Collections.sort(list);
        ListNode node = new ListNode(list.get(0));
        ListNode temp = node;
        for (int i = 1; i < list.size(); i++) {
            ListNode node1 = new ListNode(list.get(i));
            temp.next = node1;
            temp = node1;
        }
        return node;
    }

    public static ListNode test1 (ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode temp = node;
        while (null != l1 && null != l2) {
            int a = l1.val;
            int b = l2.val;
            if (a < b) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.node();
        ListNode node1 = ListNode.node();

        test(node, node1);
        test1(node, node1);
    }

}
