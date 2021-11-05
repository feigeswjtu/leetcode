package aother.nowcoder.other;

import java.util.Scanner;

/**
 * @author feigeswjtu.cyf
 * @version $Id: MainHJ107.java, v 0.1 2021-03-09 18:33 feigeswjtu.cyf Exp $$
 */
public class MainHJ107 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double n = sc.nextDouble();
            System.out.printf("%.1f", getCubeRoot(n));

        }
    }

    public static double getCubeRoot(double input) {
        double min = 0;
        double max = input;
        double mid = 0;
        while ((max - min) > 0.0001) {
            mid = (max + min) / 2;
            if (mid * mid * mid > input) {
                max = mid;
                continue;
            }
            if (mid * mid * mid < input) {
                min = mid;
                continue;
            }
            return mid;
        }
        return max;
    }
}
