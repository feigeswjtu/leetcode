package interview0106;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public String compressString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }


        char lastChar = s.charAt(0);
        int lastCharCount = 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lastChar);
        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == lastChar) {
                lastCharCount++;
            } else {
                stringBuilder.append(lastCharCount);
                stringBuilder.append(currentChar);
                lastCharCount = 1;
                lastChar = currentChar;
            }
        }

        stringBuilder.append(lastCharCount);
        return stringBuilder.toString().length() >= s.length() ? s : stringBuilder.toString();
    }
}
