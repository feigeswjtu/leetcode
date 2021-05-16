package code202;

/**
 * 是否是快乐数
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {

    public boolean isHappy(int n) {
        // 慢值
        int slow = n;

        // 快值
        int fast = n;

        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        } while (slow != fast);

        return slow == 1;
    }

    /**
     * 每位平方和
     *
     * @param n
     * @return
     */
    private int bitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }
        return sum;
    }
}

