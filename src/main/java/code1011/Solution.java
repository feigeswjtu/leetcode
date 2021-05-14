package code1011;

/**
 * 在 D 天内送达包裹的能力
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {

    public int shipWithinDays(int[] weights, int D) {
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            if (weight > left) {
                left = weight;
            }
            right += weight;
        }

        int result = right;

        while (left < right) {
            int mid = (left + right) / 2;
            int index = 0;
            int count = 1;
            int weightTemp = 0;

            while (index < weights.length && count <= D) {
                weightTemp += weights[index];
                if (weightTemp > mid) {
                    weightTemp = weights[index];
                    count++;
                }
                index++;
            }

            if (count <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }
}
