package code2;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
    @Test
    public void test(){
        ListNode l1 = new ListNode();
        ListNode l1Temp = l1;
        ListNode l1NextTemp = l1Temp;
        for (int i = 0; i < 7; i++) {
            l1NextTemp = l1Temp;
            l1Temp.val = 9;
            l1Temp.next = new ListNode();
            l1Temp = l1Temp.next;
        }

        l1NextTemp.next = null;


        ListNode l2 = new ListNode();
        ListNode l2Temp = l2;
        ListNode l2NextTemp = l2Temp;
        for (int i = 0; i < 3; i++) {
            l2NextTemp = l2Temp;

            l2Temp.val = 9;
            l2Temp.next = new ListNode();
            l2Temp = l2Temp.next;
        }

        l2NextTemp.next = null;

        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}
