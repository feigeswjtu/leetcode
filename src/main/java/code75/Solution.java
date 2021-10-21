package code75;

/**
 * 颜色分类
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    /**
     * 计数排序
     * 
     * @param nums
     */
    public void sortColors(int[] nums) {
        int[] colors = new int[3];

        for (int num : nums) {
            colors[num] = colors[num] + 1;
        }

        int index = 0;

        int[] indexs = {0, 1, 2};
        for (int i : indexs) {
            int colorCount = colors[i];
            for (int j = 0; j < colorCount; j++) {
                nums[index++] = i;
            }
        }
    }

    /**
     * 双指针
     *
     * @param nums
     */
    public void sortColors1(int[] nums) {
        int n = nums.length;
        int p = 0, q = n - 1;
        for (int i = 0; i <= q; ++i) {
            if (nums[i] == 0) {
                nums[i] = nums[p];
                nums[p] = 0;
                ++p;
            }
            if (nums[i] == 2) {
                nums[i] = nums[q];
                nums[q] = 2;
                --q;
                if (nums[i] != 1) {
                    --i;
                }
            }
        }
    }
}
