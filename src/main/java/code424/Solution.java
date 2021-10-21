package code424;

/**
 * 替换后的最长重复字符
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int characterReplacement(String s, int k) {
        int length = s.length();

        // 左右指针都从最左边开始
        int left = 0;
        int right = 0;

        // left 和right中间，最多的字母的数量
        int maxCount = 0;
        // left 和right中间，所有字母的数量
        int[] req = new int[26];

        while (right < length) {
            req[s.charAt(right) - 'A']++;
            // left 和right中间，最多的字母的数量
            maxCount = Math.max(maxCount, req[s.charAt(right) - 'A']);

            // 如果 left和right中间最多的字母数量之外的数量个数大于K，说明此时不满足条件，left减一
            if (right - left + 1 - maxCount > k) {
                req[s.charAt(left) - 'A']--;
                left++;
            }

            // right始终要右移
            right++;
        }

        return right - left;
    }
}
