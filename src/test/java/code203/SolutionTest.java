package code203;

import org.testng.annotations.Test;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
    @Test
    public void test() {
        ListNode head = new ListNode();
        head.val = 1;

        head.next = new ListNode();
        head.next.val = 2;

        head.next.next = new ListNode();
        head.next.next.val = 6;

        head.next.next.next = new ListNode();
        head.next.next.next.val = 3;

        head.next.next.next.next = new ListNode();
        head.next.next.next.next.val = 4;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.val = 5;


        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.val = 6;

        System.out.println(head);

        Solution solution = new Solution();
        ListNode listNode = solution.removeElements(head, 6);

        System.out.println(listNode);
    }
}
