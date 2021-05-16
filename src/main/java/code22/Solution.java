package code22;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        // 回溯法
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    /**
     * 回溯法
     *
     * @param result
     * @param parenthesis
     * @param leftUseCount
     * @param rightUseCount
     */
    private void backtrack(List<String> result, StringBuilder parenthesis, int leftUseCount, int rightUseCount, int n) {
        // 如果右括号使用的个数为n
        if (rightUseCount == n) {
            result.add(parenthesis.toString());
        }

        // 如果左括号使用的个数小于n
        if (leftUseCount < n) {
            parenthesis.append('(');
            backtrack(result, parenthesis, leftUseCount + 1, rightUseCount, n);
            parenthesis.deleteCharAt(parenthesis.length() - 1);
        }
        // 如果右括号使用的个数小于左括号的个数
        if (rightUseCount < leftUseCount) {
            parenthesis.append(')');
            backtrack(result, parenthesis, leftUseCount, rightUseCount + 1, n);
            parenthesis.deleteCharAt(parenthesis.length() - 1);
        }


    }
}
