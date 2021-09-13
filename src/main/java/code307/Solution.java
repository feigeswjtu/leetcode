package code307;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
}


class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;

    }

    public void update(int index, int val) {
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            result += nums[i];
        }
        return result;
    }
}