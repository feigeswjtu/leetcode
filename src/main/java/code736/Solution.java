package code736;

import java.util.ArrayList;
import java.util.List;

/**
 * 划分字母区间
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int length = S.length();
        // 存储最后出现的字符的位置
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            // 找到end值最大的
            end = Math.max(end, last[S.charAt(i) - 'a']);
            // 如果end值刚好和i相同，说明这个范围是全量数据
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

}
