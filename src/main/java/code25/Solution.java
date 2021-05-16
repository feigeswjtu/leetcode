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
        // 链表为null
        if (head == null) {
            return head;
        }
        ListNode visualHead = new ListNode();
        visualHead.next = head;


        ListNode begin = head;
        ListNode end = head;


        int distance = 0;

        ListNode headTemp = visualHead;
        // 循环处理
        while (end != null) {
            // 当距离达到k时进行翻转
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

    /**
     * 翻转
     * @param head
     * @param begin
     * @param end
     */
    private void reverse(ListNode head, ListNode begin, ListNode end) {
        // 队列存储
        Deque<ListNode> deque = new ArrayDeque<ListNode>();
        ListNode endNext = end.next;

        // 队列存储
        while (begin != end){
            deque.push(begin);
            begin = begin.next;
        }
        deque.push(end);


        // 翻转
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