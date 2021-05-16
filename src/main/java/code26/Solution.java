package code26;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int preIndex = 0;
        int currentIndex = 1;

        while (currentIndex < nums.length) {
            if (nums[preIndex] != nums[currentIndex]) {
                if (currentIndex - preIndex > 1) {
                    nums[preIndex + 1] = nums[currentIndex];
                }
                preIndex++;
            }
            currentIndex++;
        }

        return preIndex + 1;
    }
}
