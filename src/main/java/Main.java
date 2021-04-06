import java.util.Scanner;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Main.java, v 0.1 2021-03-09 17:39 feigeswjtu.cyf Exp $$
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        int count = findLastWordLength(str);
        System.out.println(count);
        return;
    }

    private static int findLastWordLength(String words) {
        int wordLength = words.length();
        if (wordLength == 0) {
            return 0;
        }
        int index = wordLength - 1;
        char c = words.charAt(index);
        int count = 0;
        while (c != ' ') {
            count++;
            index--;
            if (index < 0){
                break;
            }
            c = words.charAt(index);
        }
        return count;
    }
}
