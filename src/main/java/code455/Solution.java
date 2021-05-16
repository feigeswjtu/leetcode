package code455;

import java.util.Arrays;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gIndex = 0;
        int sIndex = 0;
        int count = 0;

        while (sIndex < s.length && gIndex < g.length) {
            if (s[sIndex] < g[gIndex]) {
                sIndex++;
                continue;
            }
            count++;
            gIndex++;
            sIndex++;
        }

        return count;
    }
}
