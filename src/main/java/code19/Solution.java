package code19;

/**
 * 删除链表的倒数第 N 个结点
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 记录两个指针的距离
        int distance = 0;
        // 慢指针
        ListNode slowNode = null;
        // 快指针
        ListNode fastNode = head;

        while (fastNode != null) {
            // 距离达到n时，慢指针开始移动
            if (distance == n) {
                slowNode = head;
                distance++;
            } else if (distance < n) {
                // 距离小于n时，距离+1
                distance++;
            } else {
                // 距离大于n时，慢移动
                slowNode = slowNode.next;
            }

            fastNode = fastNode.next;
        }

        if (slowNode != null) {
            slowNode.next = slowNode.next.next;
        }


        // 距离刚好和n相等时，倒数n个刚好是头结点
        if (distance == n){
            return head.next;
        }

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
