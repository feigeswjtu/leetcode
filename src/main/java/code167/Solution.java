package code167;

/**
 * 两数之和 II - 输入有序数组
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int left = 0;
        int right = length - 1;
        int[] result = new int[2];

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return result;
    }
}
