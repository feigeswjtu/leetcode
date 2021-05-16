package code11;

/**
 * 盛最多水的容器
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    /**
     * 双指针法
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        // 长度小于1时盛水为0
        if (height.length <= 1) {
            return 0;
        }

        // 最大面积
        int maxArea = 0;
        // 左索引
        int leftIndex = 0;
        // 右索引
        int rightIndex = height.length - 1;
        while (leftIndex < rightIndex) {

            // 高度
            int areaHeight = 0;
            // 右索引
            int rightIndexTemp = rightIndex;
            // 左索引
            int leftIndexTemp = leftIndex;
            // 获取到最小的高度
            if (height[leftIndex] <= height[rightIndex]) {
                areaHeight = height[leftIndex];
                leftIndex++;
            } else {
                areaHeight = height[rightIndex];
                rightIndex--;
            }


            // 计算面积
            int currentArea = (rightIndexTemp - leftIndexTemp) * areaHeight;
            // 得到最大面积
            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
    }
}
