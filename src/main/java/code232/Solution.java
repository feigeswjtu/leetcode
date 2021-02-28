package code232;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
class MyQueue {
    Deque<Integer> dequeIn;
    Deque<Integer> dequeOut;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        dequeIn = new ArrayDeque<>();
        dequeOut = new ArrayDeque<>();

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        moveToInDeque();
        dequeIn.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        moveToOutDeque();
        return dequeOut.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {

        moveToOutDeque();
        return dequeOut.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return dequeOut.isEmpty() && dequeIn.isEmpty();
    }

    private void moveToInDeque() {
        while (!dequeOut.isEmpty()) {
            Integer pop = dequeOut.pop();
            dequeIn.push(pop);
        }
    }

    private void moveToOutDeque() {
        while (!dequeIn.isEmpty()) {
            Integer pop = dequeIn.pop();
            dequeOut.push(pop);
        }

    }
}
