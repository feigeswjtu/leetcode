package code82;

import common.ListNode;

/**
 * 删除排序链表中的重复元素 II
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode headTemp = new ListNode();
        headTemp.next = head;

        ListNode preHead = headTemp;
        ListNode currentHead = headTemp.next;



        int currentValue;
        while (currentHead != null && currentHead.next != null){
            currentValue = currentHead.val;
            if (currentValue == currentHead.next.val){

                while (currentHead != null && currentHead.val == currentValue) {
                    currentHead = currentHead.next;
                }
                preHead.next = currentHead;
            }else {
                preHead = currentHead;
                currentHead = currentHead.next;
            }
        }

        return headTemp.next;
    }
}
