package code11;

/**
 * 盛最多水的容器
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }

        int maxArea = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        while (leftIndex < rightIndex) {

            int areaHeight = 0;
            int rightIndexTemp = rightIndex;
            int leftIndexTemp = leftIndex;
            if (height[leftIndex] <= height[rightIndex]){
                areaHeight = height[leftIndex];
                leftIndex++;
            }else {
                areaHeight = height[rightIndex];
                rightIndex--;
            }


            int currentArea = (rightIndexTemp - leftIndexTemp) * areaHeight;
            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
    }
}
