package code61;

import org.testng.annotations.Test;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
    @Test
    public void test(){
        ListNode head = new ListNode();
        ListNode headTemp = head;
        for (int i = 1; i < 1; i++) {
            headTemp.val = i;
            headTemp.next = new ListNode();
            headTemp = headTemp.next;
        }
        headTemp.val = 7;

        Solution solution = new Solution();
        ListNode listNode = solution.rotateRight(head, 0);
        System.out.println(listNode);
    }
}
