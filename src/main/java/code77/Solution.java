package code77;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 组合
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    /**
     * 回溯法
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        Set<Integer> numbers = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);

        }

        List<Integer> combine = new ArrayList<>();
        bsf(result, 1, n, combine, k);

        return result;
    }

    private void bsf(List<List<Integer>> result, int begin, int n, List<Integer> combine, int k) {
        if (combine.size() == k) {
            result.add(new ArrayList<>(combine));
            return;
        }

        for (int i = begin; i <= n; i++) {

            combine.add(i);
            bsf(result, i + 1, n, combine, k);
            combine.remove(combine.size() - 1);
        }
    }

}
