package code201;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right){
            right = right & (right -1);
        }

        return right;
    }
}
