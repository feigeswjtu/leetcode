package code876;

/**
 * 链表的中间结点
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode slowNode = head;
        ListNode fastNode = head;

        while (fastNode != null) {
            fastNode = fastNode.next;

            // 当没有达到最后一个节点时，快指针再移动一位，慢指针移动一位
            if (fastNode != null) {
                slowNode = slowNode.next;
                fastNode = fastNode.next;
            } else {
                return slowNode;
            }
        }

        return slowNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
