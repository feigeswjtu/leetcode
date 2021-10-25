package code26;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 1;
        }
        int left = 0;
        int right = 1;

        while (right < length) {
            while (right < length && nums[right] == nums[left]) {
                right++;
            }

            if (right >= length){
                break;
            }

            nums[++left] = nums[right++];
        }

        return left + 1;
    }
}
