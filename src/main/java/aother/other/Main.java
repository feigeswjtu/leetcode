package aother.other;

/**
 * TODO
 *
 * @author chenyafei
 * @version 1.0
 * @date 04/02/2018 22:20
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        long i = 0;
        while (true) {
            System.out.println(i++);
            Thread.sleep(100L);
        }
    }

}

