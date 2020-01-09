package leetcode.algorithms2;

/**
 * @author huoxianwei
 * @date 2020/1/9 13:55
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 */
public class Test82 {

    private static ListNode deleteDuplicates (ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode headHead = new ListNode(-1);
        ListNode pre = headHead;
        headHead.next = head;
        while (head != null && head.next!=null){
            if (head.val != head.next.val){
                pre = head;
                head = head.next;
            }else{
                while (head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                pre.next = head.next;
                head = head.next;
            }
        }
        return headHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,4,5};
        ListNode node = ListNode.create(nums);
        ListNode node1 = deleteDuplicates(node);
        while (null != node1) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }
}
