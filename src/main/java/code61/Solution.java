package code61;

/**
 * 旋转链表
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // 节点为Null时直接返回
        if (head == null) {
            return head;
        }

        ListNode headTemp = head;
        ListNode end = headTemp;

        int listLength = 1;

        // 确定链表长度
        while (end.next != null) {
            listLength++;
            end = end.next;
        }

        // 如果链表长度为1时，直接返回
        if (listLength == 1) {
            return head;
        }

        // 确定旋转的目标值
        int rotateTarget = (listLength - k % listLength) % listLength;

        // 如果旋转目标值为0，直接返回
        if (rotateTarget == 0) {
            return head;
        }


        ListNode midNode = headTemp;

        int rotateCount = 1;
        // 找到中间节点
        while (rotateCount < rotateTarget) {
            midNode = midNode.next;
            rotateCount++;
        }

        // 旋转处理
        ListNode midNodeNext = midNode.next;
        end.next = head;
        midNode.next = null;

        // 返回中介节点
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
