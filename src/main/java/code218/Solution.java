package code218;

import java.util.*;

/**
 * 天际线问题
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        /**
         * 优先队列，小顶堆
         *
         **/
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int[] building : buildings) {
            priorityQueue.offer(new int[]{building[0], -building[2]});
            priorityQueue.offer(new int[]{building[1], building[2]});
        }

        // 结果集
        List<List<Integer>> result = new ArrayList<>();

        // 保存高度
        TreeMap<Integer, Integer> heights = new TreeMap<>((a, b) -> b - a);

        // 上一个高度
        heights.put(0, 1);

        int left; // 上一个位置的横坐标
        int height = 0; // 上一个位置的高度

        // 优先队列处理
        while (!priorityQueue.isEmpty()) {
            int[] arr = priorityQueue.poll();
            // 如果左节点，高度入堆
            if (arr[1] < 0) {
                heights.put(-arr[1], heights.getOrDefault(-arr[1], 0) + 1);
            } else {
                // 如果右节点，高度入堆
                heights.put(arr[1], heights.get(arr[1]) - 1);
                if (heights.get(arr[1]) == 0) {
                    heights.remove(arr[1]);
                }
            }

            // 当前最大的高度如果不同于上一个高度，是一个转折点
            int maxHeight = heights.keySet().iterator().next();

            if (maxHeight != height) {
                left = arr[0];
                height = maxHeight;
                result.add(Arrays.asList(left, height));
            }
        }

        return result;
    }


}
