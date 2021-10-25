package code169;

/**
 * 多数元素
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 1;
        int index = 1;
        while (index < nums.length) {
            if (count == 0) {
                num = nums[index];
                count = 1;
                index++;
                continue;
            }

            if (num != nums[index]) {
                count--;
            } else {
                count++;

            }
            index++;
        }

        return num;
    }
}
