package code50;

/**
 * Pow(x, n)
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public double myPow(double x, int n) {
        return n >= 0 ? quickPow(x, n) : 1.0D / quickPow(x, -n);
    }

    /**
     * 使用已知的计算结果
     * @param x
     * @param n
     * @return
     */
    public double quickPow(double x, int n) {
        if (n == 0) {
            return 1.0D;
        }
        double result = quickPow(x, n / 2);
        return n % 2 == 0 ? result * result : result * result * x;
    }
}
