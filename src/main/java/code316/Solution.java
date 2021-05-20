package code316;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 去除重复字母
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        Set<Character> treeList = new TreeSet<>();
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!hashSet.contains(c)) {
                hashSet.add(c);
                treeList.add(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : treeList) {
            stringBuilder.append(character);

        }
        return stringBuilder.toString();
    }
}
