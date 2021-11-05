package aother.other;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 统计字符出现个数
 *
 * @author feigeswjtu.cyf
 * @version $Id: other.Main3.java, v 0.1 2021-03-14 14:18 feigeswjtu.cyf Exp $$
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        System.out.println(groupEveryCharCount(s));

    }

    /**
     * 统计字符出现个数
     *
     * @param s
     * @return
     */
    private static String groupEveryCharCount(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Map<Character, AtomicInteger> map = new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!map.containsKey(c)) {
                AtomicInteger integer = new AtomicInteger(1);
                map.put(c, integer);
                continue;
            } else {
                map.get(c).incrementAndGet();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        map.forEach((key, value) -> {
            stringBuilder.append(key);
            stringBuilder.append(value.get());
        });

        return stringBuilder.toString();

    }
}
