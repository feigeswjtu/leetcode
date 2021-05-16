package code141;

/**
 * 环形链表
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        if (head.next == head) {
            return true;
        }

        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null) {
            slowNode = slowNode.next;
            if (fastNode.next == null) {
                return false;
            }
            fastNode = fastNode.next.next;
            if (slowNode == fastNode && slowNode != null) {
                return true;
            }
        }

        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}