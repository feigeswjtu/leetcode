package code258;

/**
 * 各位相加
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
