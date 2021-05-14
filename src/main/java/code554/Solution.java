package code554;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int maxCount = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (List<Integer> widths : wall) {
            int sumWidth = 0;
            for (int i = 0; i < widths.size() - 1; i++) {
                int width = widths.get(i);

                sumWidth += width;
                if (countMap.containsKey(sumWidth)) {
                    int count = countMap.get(sumWidth) + 1;
                    countMap.put(sumWidth, count);
                    maxCount = Math.max(maxCount, count);
                } else {
                    maxCount = Math.max(maxCount, 1);
                    countMap.put(sumWidth, 1);
                }
            }
        }
        return wall.size() - maxCount;

    }
}
