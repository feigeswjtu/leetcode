package aother.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 顾客下单个数
 *
 * @author feigeswjtu.cyf
 * @version $Id: other.Main1.java, v 0.1 2021-03-13 21:59 feigeswjtu.cyf Exp $$
 */
public class Main1 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        List<String> originData = new ArrayList<>();
        while (scanner.hasNextLine()) {
            originData.add(scanner.nextLine());
        }
        List<Date> orderDates = new ArrayList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");


        for (String originDatum : originData) {
            orderDates.add(simpleDateFormat.parse(originDatum));
        }

        System.out.println(getCunstomerCount(orderDates));
    }

    /**
     * 顾客个数
     *
     * @param orderDates
     * @return
     */
    private static int getCunstomerCount(List<Date> orderDates) {

        if (orderDates == null || orderDates.size() == 0) {
            return 0;
        }
        orderDates.sort(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o1.compareTo(o2);
            }
        });
        int cunstomerCount = 1;
        Date preDate = orderDates.get(0);
        for (int i = 1; i < orderDates.size(); i++) {
            Date currentDate = orderDates.get(i);
            if (currentDate.equals(preDate)) {
                cunstomerCount++;
            } else {
                if (!isOneSeccond(currentDate, preDate)) {
                    preDate = currentDate;
                    cunstomerCount++;
                }
            }
        }
        return cunstomerCount;

    }

    /**
     * 是否是同一秒
     *
     * @param date1
     * @param date2
     * @return
     */
    private static boolean isOneSeccond(Date date1, Date date2) {
        return date1.getYear() == date2.getYear()
                &&
                date1.getMonth() == date2.getMonth()
                &&
                date1.getDay() == date2.getDay()
                &&
                date1.getHours() == date2.getHours()
                &&
                date1.getMinutes() == date2.getMinutes()
                &&
                date1.getSeconds() == date2.getSeconds();
    }
}
