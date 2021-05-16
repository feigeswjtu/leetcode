package code138;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public Node copyRandomList(Node head) {
        // 头节点为null时直接返回
        if (head == null) {
            return null;
        }

        // 存储老节点和新节点的映射
        Map<Node, Node> oldToNew = new HashMap<>();

        // 新节点
        Node newHead = new Node(head.val);
        newHead.next = head.next;
        newHead.random = head.random;
        // 存储映射关系
        oldToNew.put(head, newHead);

        Node newHeadTemp = newHead;
        Node headTemp = head;


        while (headTemp.next != null) {

            // 构造新节点
            Node temp = new Node(headTemp.next.val);
            temp.next = headTemp.next.next;
            temp.random = headTemp.next.random;
            newHeadTemp.next = temp;

            // 把新老节点映射存储起来
            oldToNew.put(headTemp.next, newHeadTemp.next);

            // 指针向前移动
            headTemp = headTemp.next;
            newHeadTemp = newHeadTemp.next;

        }

        newHeadTemp = newHead;

        while (newHeadTemp != null) {
            // 处理随机指针
            newHeadTemp.random = oldToNew.get(newHeadTemp.random);
            // 指针向前移动
            newHeadTemp = newHeadTemp.next;
        }


        return newHead;

    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
