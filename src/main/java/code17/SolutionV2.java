package code17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 * 回溯法
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionV2 {
    private Map<Character, List<Character>> digitsMap = new HashMap<>();

    public SolutionV2() {
        init();
    }

    private void init() {
        digitsMap.put('2', Arrays.asList('a', 'b', 'c'));
        digitsMap.put('3', Arrays.asList('d', 'e', 'f'));
        digitsMap.put('4', Arrays.asList('g', 'h', 'i'));
        digitsMap.put('5', Arrays.asList('j', 'k', 'l'));
        digitsMap.put('6', Arrays.asList('m', 'n', 'o'));
        digitsMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
        digitsMap.put('8', Arrays.asList('t', 'u', 'v'));
        digitsMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> digitsToChars = new ArrayList<>(digits.length());
        StringBuilder stringBuilder = new StringBuilder();
        dfs(digitsToChars, stringBuilder, 0, digits);
        return digitsToChars;
    }

    public void dfs(List<String> digitsToChars, StringBuilder stringBuilder, int useSize, String digits) {
        char c = digits.charAt(useSize);
        List<Character> characters = digitsMap.get(c);
        if (useSize == digits.length() - 1) {
            for (Character character : characters) {
                StringBuilder append = stringBuilder.append(character);
                digitsToChars.add(append.toString());
                stringBuilder.deleteCharAt(append.length() - 1);
            }
            return;
        }


        for (Character character : characters) {
            StringBuilder append = stringBuilder.append(character);
            dfs(digitsToChars, stringBuilder, useSize + 1, digits);
            stringBuilder.deleteCharAt(append.length() - 1);
        }
    }
}
