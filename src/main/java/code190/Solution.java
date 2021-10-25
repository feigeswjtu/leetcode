package code190;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 31; i++) {
            result |= (n & 1) << (31 - i);
            n = n >>> 1;
        }

        return result;
    }
}
