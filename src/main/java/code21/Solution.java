package code21;

/**
 * 合并两个有序链表
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟头结点，防止合并的时候丢失头节点
        ListNode visualHead = new ListNode();
        ListNode headTemp = visualHead;
        ListNode head1 = l1;
        ListNode head2 = l2;

        while (head1 != null || head2 != null) {
            // 两个链表都不为空时
            if (head1 != null && head2 != null) {
                if (head1.val <= head2.val) {
                    headTemp.next = head1;
                    head1 = head1.next;
                    headTemp = headTemp.next;
                } else {
                    headTemp.next = head2;
                    head2 = head2.next;
                    headTemp = headTemp.next;
                }
                // 链表1不为空时
            } else if (head1 != null) {
                headTemp.next = head1;
                break;
                // 链表1不为空时
            } else {
                headTemp.next = head2;
                break;
            }
        }

        return visualHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}