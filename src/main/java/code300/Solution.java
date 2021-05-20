package code300;

/**
 * 最长递增子序列
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-25 22:44 feigeswjtu.cyf Exp $$
 */
class Solution {
    public int lengthOfLIS(int[] arrays) {
        if (arrays.length <= 1) {
            return arrays.length;
        }
        int[] maxLengthArray = new int[arrays.length];
        maxLengthArray[0] = 1;
        int maxLength = maxLengthArray[0];

        for (int i = 1; i < arrays.length; i++) {
            maxLengthArray[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arrays[i] > arrays[j]) {
                    maxLengthArray[i] = Math.max(maxLengthArray[i], maxLengthArray[j] + 1);
                }
            }

            maxLength = Math.max(maxLength, maxLengthArray[i]);

        }

        return maxLength;
    }
}