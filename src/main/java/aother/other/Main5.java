package aother.other;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author feigeswjtu.cyf
 * @version $Id: other.Main5.java, v 0.1 2021-03-17 20:51 feigeswjtu.cyf Exp $$
 */
public class Main5 {

    public static void main(String[] args) {
        int[] nums = {4, 2, 0, 3, 3, 0};
        int rain = rain(nums);
        System.out.println(rain);
        int[] nums1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        rain = rain(nums1);
        System.out.println(rain);
    }
    private static int rain(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int rain = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(0);
        for (int i = 1; i < nums.length; i++) {
            int currentHeight = nums[i];
            if (deque.isEmpty()){
                deque.push(i);
                continue;
            }
            while (!deque.isEmpty()) {
                Integer preIndex = deque.peek();
                Integer preHeight = nums[preIndex];
                if (currentHeight <= preHeight) {
                    deque.push(i);
                    break;
                } else {
                    deque.pop();
                    if (!deque.isEmpty()) {
                        int prepreIndex = deque.peek();
                        Integer prepreHeight = nums[prepreIndex];
                        rain += (Math.min(prepreHeight, currentHeight) - preHeight) * (i - prepreIndex - 1);
                    }
                }
            }
            if (deque.isEmpty()){
                deque.push(i);
            }

        }

        return rain;

    }
}
