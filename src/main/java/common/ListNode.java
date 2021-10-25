package common;

/**
 * @author feigeswjtu.cyf
 * @version $Id: ListNode.java, v 0.1 2021-10-24 19:56 feigeswjtu.cyf Exp $$
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}