package code25;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * K 个一组翻转链表
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode visualHead = new ListNode();
        visualHead.next = head;


        ListNode begin = head;
        ListNode end = head;


        int distance = 0;

        ListNode headTemp = visualHead;
        while (end != null) {
            if (distance == k - 1) {
                reverse(headTemp, begin, end);
                headTemp = begin;
                begin = end = headTemp.next;
                distance = 0;
            } else if (distance < k - 1) {
                distance ++;
                end = end.next;
            }
        }


        return visualHead.next;
    }

    private void reverse(ListNode head, ListNode begin, ListNode end) {
        Deque<ListNode> deque = new ArrayDeque<ListNode>();
        ListNode endNext = end.next;
        while (begin != end){
            deque.push(begin);
            begin = begin.next;
        };
        deque.push(end);


        while (!deque.isEmpty()){
            ListNode pop = deque.pop();
            head.next = pop;
            head = head.next;
        }

        head.next = endNext;
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