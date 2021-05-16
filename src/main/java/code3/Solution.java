package code3;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 00:53 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 字符串为空
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // hash存储字符串
        Set<Character> hashSet = new HashSet<Character>();
        int length = s.length();
        int indexLeft = 0;
        int indexRight = 0;
        int maxLength = 0;

        while (indexRight < length) {
            // 如果在hashSet里不存在，则indexRight++
            if (!hashSet.contains(s.charAt(indexRight))) {
                hashSet.add(s.charAt(indexRight));
                indexRight++;
            } else {
                hashSet.remove(s.charAt(indexLeft));
                indexLeft++;
            }
            // 找到最大长度
            maxLength = Math.max(maxLength, indexRight - indexLeft);
        }

        return maxLength;
    }
}
