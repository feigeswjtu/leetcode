package code96;

/**
 * 不同的二叉搜索树
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    /**
     * 动态规划法
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        // 长度为0的节点能构成的数量
        G[0] = 1;

        // 长度为1的节点能构成的数量
        G[1] = 1;

        // 长度为i的节点能构成的数量
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                // 长度为i的节点能构成的数量为长度为0到长度为i-1
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
