package code6;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }

        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < stringBuilders.length; i++) {
            stringBuilders[i] = new StringBuilder();
        }

        int length = s.length();
        int countPerGroup = numRows * 2 - 2;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int remainCount = i% countPerGroup;

            if (remainCount < numRows) {
                stringBuilders[remainCount].append(c);
            } else {
                stringBuilders[ numRows - (remainCount + 1 - numRows) - 1].append(c);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder builder : stringBuilders) {
            stringBuilder.append(builder);
        }
        return stringBuilder.toString();

    }
}
