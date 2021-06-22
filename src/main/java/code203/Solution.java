package code203;

/**
 * 移除链表元素
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode headTemp = new ListNode();
        headTemp.next = head;

        ListNode tempNode = headTemp;
        while (tempNode.next != null) {
            ListNode next = tempNode.next;
            if (next.val == val) {
                tempNode.next = next.next;
                continue;
            }

            tempNode = tempNode.next;
        }

        return headTemp.next;
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
