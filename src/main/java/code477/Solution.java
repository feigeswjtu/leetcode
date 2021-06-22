package code477;

/**
 * 汉明距离总和
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int distance = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                int b = nums[j];
                if (((b >> i) & 1) == 1) {
                    count++;
                }

            }
            distance += count * (nums.length - count);
        }
        return distance;
    }

    public int totalHammingDistance1(int[] nums) {
        int distance = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = nums[i];
                int b = nums[j];
                int c = a ^ b;
                distance += calDistance(c);
            }
        }
        return distance;
    }

    /**
     * 计算位数为1的数量
     *
     * @param c
     * @return
     */
    private int calDistance(int c) {
        int distance = 0;
        int one = 1;
        while ((c & (~0)) > 0) {
            if ((c & one) == one) {
                distance++;
            }
            c = c >> 1;
        }

        return distance;
    }
}
