package code2;

/**
 * 两数相加
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        ListNode nextTemp = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            nextTemp = temp;
            int value = carry;
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            if (value >= 10) {
                carry = value / 10;
            } else {
                carry = 0;
            }

            temp.val = value % 10;
            temp.next = new ListNode();
            temp = temp.next;
        }

        // 没有进位时
        if (carry != 0) {
            temp.val = carry;
        }else {
            nextTemp.next = null;

        }

        return result;
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

