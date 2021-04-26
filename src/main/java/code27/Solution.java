package code27;

/**
 * 移除元素
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int beginIndex = 0;

        int endIndex = nums.length - 1;
        while (beginIndex <= endIndex) {
            int value = nums[beginIndex];

            if (val == value) {
                nums[beginIndex] = nums[endIndex];
                endIndex--;
            } else {
                beginIndex++;
            }
        }

        return endIndex + 1;
    }
}
