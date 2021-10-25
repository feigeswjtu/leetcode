package code83;

import common.ListNode;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        ListNode nextNode = node.next;
        while (nextNode != null) {
            if (nextNode.val == node.val) {
                nextNode = nextNode.next;
                node.next = nextNode;
                continue;
            }
            node.next = nextNode;
            node = nextNode;
            nextNode = node.next;
        }

        return head;
    }

    public ListNode deleteDuplicatesV2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicatesV3(ListNode head) {
        process(head, 1);
        return head;
    }

    public void process(ListNode head, int k) {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        int distance = 0;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
                distance++;
                int tempValue = temp.val;
                if (distance == k) {
                    while (temp.next != null && temp.next.val == tempValue) {
                        temp.next = temp.next.next;
                        distance = 0;
                    }

                }
            } else {
                temp = temp.next;
            }
        }
    }

}
