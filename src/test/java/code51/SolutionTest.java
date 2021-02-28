package code51;

import org.testng.annotations.Test;

import java.util.List;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test() {
        List<List<String>> lists = solution.solveNQueens(0);
        System.out.println(lists.size());

        lists = solution.solveNQueens(1);
        System.out.println(lists.size());

    }

    @Test
    public void test1() {
        List<List<String>> lists = solution.solveNQueens(8);
        System.out.println(lists.size());
    }
}
