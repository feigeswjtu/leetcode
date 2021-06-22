package code401;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        // 10位数字循环
        for (int i = 0; i < 1024; ++i) {
            // 用位运算取出高 4 位和低 6 位
            int h = i >> 6, m = i & 63;
            // 小时小于12并且分钟位小于60
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                result.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return result;
    }
}

