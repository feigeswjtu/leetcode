package aother.nowcoder.other;

import java.util.Scanner;

public class MainHJ108 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a == 0) {
            System.out.println(b);;
            return;
        }

        if (b == 0) {
            System.out.println(a);;
            return;
        }


        int max = max(a, b);
        System.out.println(a*b/max);;

    }


    /**
     * 最大公约数据
     *
     * @return
     */
    private static int max(int a, int b) {
        int big = a;
        int small = b;
        if (a < b) {
            small = a;
            big = b;
        }

        if (big % small == 0){
            return small;
        }

        for(int v = small/2; v >= 1; v--){
            if (big % v == 0 && small % v == 0){
                return v;
            }
        }

        return 1;
    }


}
