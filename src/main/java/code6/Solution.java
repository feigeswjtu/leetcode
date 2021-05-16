package code6;

/**
 * Z 字形变换
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        // 构造numRows的StringBuilder
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < stringBuilders.length; i++) {
            stringBuilders[i] = new StringBuilder();
        }

        int length = s.length();
        // 一个半Z字型对应的字符数量
        int countPerGroup = numRows * 2 - 2;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            // 剩余数量
            int remainCount = i % countPerGroup;

            // 如果剩余数量小于行数，对应的stringBuilder进行操作
            if (remainCount < numRows) {
                stringBuilders[remainCount].append(c);
            } else {
                // 反向选择StringBuilder进行操作
                stringBuilders[numRows - (remainCount + 1 - numRows) - 1].append(c);
            }
        }

        // 最后处理结果
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder builder : stringBuilders) {
            stringBuilder.append(builder);
        }
        return stringBuilder.toString();

    }
}
