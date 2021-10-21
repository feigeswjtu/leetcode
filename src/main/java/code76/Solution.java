package code76;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最小覆盖子串
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        int[] need = new int[128];
        //记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        //遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {//需要字符c
                count--;
            }
            need[c]--;//把右边的字符加入窗口
            if (count == 0) {//窗口中已经包含所有字符
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;//释放右边移动出窗口的字符
                    l++;//指针右移
                }
                if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = r - l + 1;
                    start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

    /**
     * 未写出来的版本
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow1(String s, String t) {
        Map<Character, Integer> originCharCountMap= new HashMap<>();
        Set<Character> charSet= new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (charSet.contains(c)){
                originCharCountMap.put(c, originCharCountMap.get(c)+1);
            }else {
                charSet.add(c);
                originCharCountMap.put(c, 1);
            }
        }
        int indexLeft = 0;
        int indexRight = 0;
        int minIndexLeft = 0;
        int minIndexRight= s.length()-1;

        boolean hit = false;
        int length = s.length();
        Map<Character, Integer> charCountMap= new HashMap<>();

        while (indexRight < length){
            if (!check(originCharCountMap, charCountMap)){
                char c = s.charAt(indexRight);
                indexRight++;
                if (!originCharCountMap.containsKey(c)){
                    continue;
                }
                if (!charCountMap.containsKey(c)) {
                    charCountMap.put(c, 1);
                } else {
                    charCountMap.put(c, charCountMap.get(c)+1);
                }
            }else {
                hit = true;
                int currentLength = indexRight - indexLeft;
                if (currentLength < minIndexRight -minIndexLeft){
                    minIndexRight = indexRight;
                    minIndexLeft = indexLeft;
                }
                char c = s.charAt(indexLeft);
                indexLeft++;
                if (!originCharCountMap.containsKey(c)){
                    continue;
                }
                Integer integer = charCountMap.get(c);
                if (integer== null){
                }else if (integer == 1){
                    charCountMap.remove(c);
                }else {
                    charCountMap.put(c, --integer);
                }

            }
        }

        if (hit) {
            return s.substring(minIndexLeft, minIndexRight);
        }else {
            return "";
        }
    }

    private boolean check(Map<Character, Integer> originCharCountMap, Map<Character, Integer> charCountMap){
        for (Map.Entry<Character, Integer> entry : originCharCountMap.entrySet()) {
            Character key = entry.getKey();
            if(!charCountMap.containsKey(key)){
                return false;
            }

            if (charCountMap.get(key) < originCharCountMap.get(key)){
                return false;
            }
        }

        return true;

    }

}
