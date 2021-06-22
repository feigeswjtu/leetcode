package code24;

/**
 * 两两交换链表中的节点
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }


        ListNode headTemp = new ListNode();
        headTemp.next = head;

        ListNode beforHead = headTemp;

        while (head.next != null) {
            ListNode node1 = head;
            ListNode node2 = head.next;
            ListNode node3 = node2.next;

            beforHead.next = node2;
            node2.next = node1;
            node1.next = node3;

            if (node3 == null) {
                break;
            }

            beforHead = node1;
            head = node3;
        }


        head = headTemp.next;
        headTemp.next = null;
        return head;
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