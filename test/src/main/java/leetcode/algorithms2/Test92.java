package leetcode.algorithms2;

/**
 * @author huoxianwei
 * @date 2020/1/15 16:30
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 */
public class Test92 {

    private ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode node = res;
        //找到需要反转的那一段的上一个节点。
        for (int i = 1; i < m; i++) {
            node = node.next;
        }
        //node.next就是需要反转的这段的起点。
        ListNode nextHead = node.next;
        ListNode next = null;
        ListNode pre = null;
        //反转m到n这一段
        for (int i = m; i <= n; i++) {
            next = nextHead.next;
            nextHead.next = pre;
            pre = nextHead;
            nextHead = next;
        }
        //将反转的起点的next指向next。
        node.next.next = next;
        //需要反转的那一段的上一个节点的next节点指向反转后链表的头结点
        node.next = pre;
        return res.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int m = 2, n = 4;
        ListNode node = new Test92().reverseBetween(ListNode.create(nums), m, n);
        ListNode.out(node);
    }
}
