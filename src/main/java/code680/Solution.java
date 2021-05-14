package code680;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public boolean validPalindrome(String s) {
        int length = s.length();
        int leftIndex = 0;

        int rightIndex = length - 1;

        boolean isPalindrome = true;

        while (leftIndex < rightIndex) {
            char leftChar = s.charAt(leftIndex);
            char rightChar = s.charAt(rightIndex);

            if (leftChar == rightChar) {
                leftIndex++;
                rightIndex--;
                continue;
            }

            return isPalindrome(s, leftIndex+1, rightIndex) || isPalindrome(s, leftIndex, rightIndex-1);
        }

        return isPalindrome;
    }

    private boolean isPalindrome(String s, int leftIndex, int rightIndex) {
        while (leftIndex <= rightIndex) {
            if (s.charAt(leftIndex) != s.charAt(rightIndex)) {
                return false;
            }

            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}
