package code54;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SolutionTest.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class SolutionTest {
    Solution solution = new Solution();
    @Test
    public void test(){
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        List<Integer> list = solution.spiralOrder(matrix);
        Assert.assertEquals(list.size(), 12);
    }

    @Test
    public void test1(){
        int[][] matrix = {
                {1,2,3},
                {4,5,6,},
                {7,8,9}
        };
        List<Integer> list = solution.spiralOrder(matrix);
        Assert.assertEquals(list.size(), 9);
    }

    @Test
    public void test2(){
        int[][] matrix = {
                {6,9,7},
        };
        List<Integer> list = solution.spiralOrder(matrix);
        Assert.assertEquals(list.size(), 3);
    }

    @Test
    public void test3(){
        int[][] matrix = {
                {1,2,3},
                {4,5,6,},
                {7,8,9},
                {10,11,12},
                {13,14,15}
        };
        List<Integer> list = solution.spiralOrder(matrix);
        Assert.assertEquals(list.size(), 15);
    }

}

