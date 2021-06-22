package code525;

import java.util.HashMap;
import java.util.Map;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        // 最大结果
        int maxLength = 0;
        // 存储结果值
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // counter值
        int counter = 0;
        // 初始化一个值
        map.put(counter, -1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 如果值为1时，counter值+1
            if (num == 1) {
                counter++;
                // 如果值为0时，counter值-1
            } else {
                counter--;
            }
            // 如果map里存储和相同的数量，说明这两个索引之间的0,1数量相同
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                // 取出索引相减
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                // 不存在时放入值
                map.put(counter, i);
            }
        }
        // 返回最大数量
        return maxLength;
    }

}
