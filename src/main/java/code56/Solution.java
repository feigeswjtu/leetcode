package code56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        // 先进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> list = new ArrayList<int[]>();

        int[] tempArray = new int[2];

        tempArray[0] = intervals[0][0];
        tempArray[1] = intervals[0][1];

        list.add(tempArray);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // 从第2个区间开始处理
            if (interval[1] <= list.get(list.size() - 1)[1]) {
            } else if (interval[0] <= list.get(list.size() - 1)[1]) {
                list.get(list.size() - 1)[1] = interval[1];
            } else {

                tempArray = new int[2];

                tempArray[0] = interval[0];
                tempArray[1] = interval[1];
                list.add(tempArray);
            }
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);

        }

        return result;
    }
}
