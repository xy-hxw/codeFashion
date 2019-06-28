package leetcode.algorithms;

/**
 * @author huoxianwei
 * @date 2019/6/24 19:52
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 */
public class Test2 {
    public static ListNode test (ListNode l1, ListNode l2) {
        int num = 0;
        StringBuilder sb = new StringBuilder();
        ListNode rNode = null;
        ListNode next = null;
        while (null != l1 || null != l2) {
            int first = null==l1?0:l1.val;
            int second = null==l2?0:l2.val;
            int real = (first + second + num) % 10;
            num = (first + second + num) / 10;
            if (null == rNode) {
                rNode = new ListNode(real);
                next = rNode;
            } else {
                ListNode newNode = new ListNode(real);
                next.next = newNode;
                next = newNode;
            }
            sb.append(real);
            l1 = null==l1?null:l1.next;
            l2 = null==l2?null:l2.next;
        }
        if (num > 0) {
            next.next = new ListNode(num);
            sb.append(num);
        }
        System.out.println(sb.reverse().toString());
        return rNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(6);
        ListNode node1 = new ListNode(4);
        ListNode node = test(listNode1, node1);
        while (null != node) {
            System.out.print(node.val);
            node = node.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
