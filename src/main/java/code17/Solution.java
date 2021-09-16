package code17;

import java.util.*;

/**
 * 电话号码的字母组合
 * 迭代法
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    private Map<Integer, List<Character>> digitsMap = new HashMap<>();

    public Solution() {
        init();
    }

    private void init() {
        digitsMap.put(2, Arrays.asList('a', 'b', 'c'));
        digitsMap.put(3, Arrays.asList('d', 'e', 'f'));
        digitsMap.put(4, Arrays.asList('g', 'h', 'i'));
        digitsMap.put(5, Arrays.asList('j', 'k', 'l'));
        digitsMap.put(6, Arrays.asList('m', 'n', 'o'));
        digitsMap.put(7, Arrays.asList('p', 'q', 'r', 's'));
        digitsMap.put(8, Arrays.asList('t', 'u', 'v'));
        digitsMap.put(9, Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<List<Character>> digitsToChars = new ArrayList<>(digits.length());

        for (int i = 0; i < digits.length(); i++) {
            Integer index = Integer.valueOf(digits.substring(i, i + 1));
            digitsToChars.add(digitsMap.get(index));
        }

        List<String> result = new ArrayList<>();

        int totalCount = 1;


        int[] indexCounts = new int[digits.length()];

        indexCounts[digitsToChars.size() - 1] = 1;

        for (int i = digitsToChars.size() - 1; i > 0; i--) {
            List<Character> digitsToChar = digitsToChars.get(i);
            totalCount *= digitsToChar.size();
            indexCounts[i - 1] = indexCounts[i] * digitsToChar.size();
        }

        totalCount *= digitsToChars.get(0).size();

        int count = 1;
        int[] indexs = new int[digits.length()];

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < digitsToChars.size(); i++) {
            List<Character> characters = digitsToChars.get(i);
            stringBuilder.append(characters.get(0));
        }
        indexs[digits.length() - 1] = 1;
        result.add(stringBuilder.toString());

        while (count < totalCount) {
            stringBuilder = new StringBuilder();

            for (int i = 0; i < digitsToChars.size(); i++) {
                List<Character> characters = digitsToChars.get(i);
                stringBuilder.append(characters.get(indexs[i]));
                if ((count + 1) % indexCounts[i] == 0) {
                    indexs[i] = (indexs[i] + 1) % characters.size();
                }
            }
            count++;

            result.add(stringBuilder.toString());

        }

        return result;

    }
}
