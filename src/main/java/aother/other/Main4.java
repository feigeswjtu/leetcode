package aother.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 和为目标值的所有子序列个数
 *
 * @author feigeswjtu.cyf
 * @version $Id: other.Main4.java, v 0.1 2021-03-14 14:31 feigeswjtu.cyf Exp $$
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCount = scanner.nextInt();
        int count = 0;
        int[] nums = new int[totalCount];
        while (scanner.hasNextInt() && count < totalCount) {
            nums[count++] = scanner.nextInt();
        }

        System.out.println(pointToTarget(nums));

    }

    /**
     * 和为target值的个数
     *
     * @param nums
     * @return
     */
    private static int pointToTarget(int[] nums) {

        Arrays.sort(nums);
        HashMap<Integer, AtomicInteger> valueCountMap = new HashMap<>(23);

        int targetCount = 0;

        int index = 0;

        for (int num : nums) {
            if (!valueCountMap.containsKey(num)) {
                AtomicInteger integer = new AtomicInteger(1);
                valueCountMap.put(num, integer);
                continue;
            } else {
                valueCountMap.get(num).incrementAndGet();
            }
        }

        while (index < nums.length) {
            int num = nums[index];
            valueCountMap.get(num).decrementAndGet();
            targetCount += dfsCount(valueCountMap, 24 - num, num);
            valueCountMap.get(num).incrementAndGet();
            index++;
        }

        return targetCount;
    }

    private static int dfsCount(HashMap<Integer, AtomicInteger> valueCountMap, int targetValue, int maxValue) {
        if (targetValue > maxValue) {
            return 0;
        }
        int count = 0;
        if (valueCountMap.containsKey(targetValue) && valueCountMap.get(targetValue).get() > 0) {
            count++;
        }

        for (int i = 1; i <= targetValue / 2; i++) {
            if (valueCountMap.containsKey(i) && valueCountMap.get(i).get() > 0 && valueCountMap.containsKey(targetValue - i) && valueCountMap.get(targetValue - i).get() > 0) {
                valueCountMap.get(i).decrementAndGet();
                int leftCount = dfsCount(valueCountMap, i, i);
                valueCountMap.get(i).incrementAndGet();

                int rightCount = dfsCount(valueCountMap, targetValue - i, targetValue -i);

                valueCountMap.get(targetValue - i).decrementAndGet();
                valueCountMap.get(targetValue - i).incrementAndGet();

                count += Math.min(leftCount, rightCount);

            }
        }


        return count;
    }

}
