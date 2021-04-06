package code781;

import java.util.HashMap;
import java.util.Map;

/**
 * 森林中的兔子
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int numRabbits(int[] answers) {
        // 答案为null或者空时兔子数量为0
        if (answers == null || answers.length == 0) {
            return 0;
        }

        int minTotal = 0;
        Map<Integer, Integer> answerGroup = new HashMap<>();

        for (int answer : answers) {
            if (answer == 0) {
                minTotal += 1;
                continue;
            }
            if (!answerGroup.containsKey(answer)) {
                minTotal += (answer + 1);
                answerGroup.put(answer, 1);
                continue;
            }

            Integer count = answerGroup.get(answer);
            if (count % (answer+1) == 0) {
                minTotal += (answer + 1);
            }

            answerGroup.put(answer, ++count);

        }

        return minTotal;
    }
}
