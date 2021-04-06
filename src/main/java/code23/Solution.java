package code23;

/**
 * 合并K个升序链表
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        ListNode nodeTemp = lists[0];
        for (int i = 1; i < lists.length; i++) {
            nodeTemp = mergeTwoLists(nodeTemp, lists[i]);
        }

        return nodeTemp;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode visualHead = new ListNode();
        ListNode headTemp = visualHead;
        ListNode head1 = l1;
        ListNode head2 = l2;

        while (head1 != null || head2 != null) {
            if (head1 != null && head2 != null) {
                if (head1.val <= head2.val) {
                    headTemp.next = head1;
                    head1 = head1.next;
                    headTemp = headTemp.next;
                    continue;
                } else {
                    headTemp.next = head2;
                    head2 = head2.next;
                    headTemp = headTemp.next;
                    continue;
                }
            } else if (head1 != null) {
                headTemp.next = head1;
                break;
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

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
