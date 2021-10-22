package code79;

/**
 * 单词搜索
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] usedIndexs = new boolean[board.length][board[0].length];

        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean result = dfs(board, i, j, index, word, usedIndexs);
                if (result) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int index, String word, boolean[][] usedIndexs) {
        boolean result = false;
        if (i < 0 || i >= board.length) {
            return false;
        }

        if (j < 0 || j >= board[0].length) {
            return false;
        }

        if (usedIndexs[i][j]) {
            return false;
        }

        if (index >= word.length()) {
            return false;
        }

        if (index == word.length() - 1) {
            return board[i][j] == word.charAt(index);
        }

        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        usedIndexs[i][j] = true;
        result = dfs(board, i, j + 1, index + 1, word, usedIndexs) || dfs(board, i + 1, j, index + 1, word, usedIndexs)
            || dfs(board, i, j - 1, index + 1, word, usedIndexs) || dfs(board, i - 1, j, index + 1, word, usedIndexs);
        usedIndexs[i][j] = false;

        return result;

    }
}
