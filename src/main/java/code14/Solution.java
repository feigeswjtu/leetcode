package code14;

/**
 * 最长公共前缀
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // 公共前缀的index
        int prefixIndex = 0;
        // 是否有公共前缀
        boolean hasCommonPrefix = true;

        while (hasCommonPrefix) {
            if (strs[0].length() < prefixIndex + 1) {
                break;
            }
            char c = strs[0].charAt(prefixIndex);
            for (int i = 1; i < strs.length; i++) {
                String str = strs[i];
                if (str.length() < prefixIndex + 1) {
                    hasCommonPrefix = false;
                    break;
                }
                if (c != str.charAt(prefixIndex)) {
                    hasCommonPrefix = false;
                    break;
                }
            }
            if (hasCommonPrefix) {
                prefixIndex++;
            }
        }

        return strs[0].substring(0, prefixIndex);
    }

}
