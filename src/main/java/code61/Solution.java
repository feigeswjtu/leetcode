package code61;

/**
 * 旋转链表
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode headTemp = head;
        ListNode end = headTemp;

        int listLength = 1;

        while (end.next != null) {
            listLength++;
            end = end.next;
        }

        if (listLength == 1) {
            return head;
        }

        int rotateTarget = (listLength - k % listLength) % listLength;

        if (rotateTarget == 0) {
            return head;
        }


        ListNode midNode = headTemp;

        int rotateCount = 1;
        while (rotateCount < rotateTarget) {
            midNode = midNode.next;
            rotateCount++;
        }

        ListNode midNodeNext = midNode.next;
        end.next = head;
        midNode.next = null;

        return midNodeNext;

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
