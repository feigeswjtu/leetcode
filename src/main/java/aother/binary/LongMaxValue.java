package aother.binary;

/**
 * 长整型最大长度
 *
 * @author feigeswjtu.cyf
 * @version $Id: LongMaxValue.java, v 0.1 2021-04-02 08:26 feigeswjtu.cyf Exp $$
 */
public class LongMaxValue {
    public static void main(String[] args) {
        System.out.println(calValue(38)); // 时间戳
        System.out.println(calValue(7));  // workId(服务名)
        System.out.println(calValue(9));  // 业务码
        System.out.println(calValue(9));  // sequence
        System.out.println(100L * 366 * 24 * 60 * 60 * 100);

    }

    private static long calValue(int bitLength) {
        long value = 0;
        int index = 0;
        while (index <= bitLength) {
            value += Math.pow(2, index);
            index++;
        }

        return value;
    }

}
