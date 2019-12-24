package leetcode.algorithms1;

/**
 * @author huoxianwei
 * @date 2019/7/11 14:06
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度
 */
public class Test23 {

    public static ListNode test(ListNode[] lists) {
        ListNode node = new ListNode(0);
        ListNode temp = node;
        while (true) {
            int index = 0;
            ListNode min = null;
            for (int i = 0; i < lists.length; i++) {
                ListNode listNode = lists[i];
                if (null != listNode) {
                    if (null == min) {
                        min = listNode;
                    } else if (listNode.val < min.val) {
                        min = listNode;
                    } else {
                        continue;
                    }
                    index = i;
                }
            }
            if (null == min) {
                break;
            }
            ListNode listNode = lists[index];
            temp.next = listNode;
            temp = listNode;
            lists[index] = listNode.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(5);
        a.next = a1;
        a1.next = a2;
        ListNode b = new ListNode(1);
        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        b.next = b1;
        b1.next = b2;
        ListNode c = new ListNode(2);
        c.next = new ListNode(6);
        ListNode[] lists = {a, b, c};
        ListNode test = test(lists);
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
