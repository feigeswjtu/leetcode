package code4;

/**
 * 寻找两个正序数组的中位数
 *
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalCount = nums1.length + nums2.length;

        int targetCount = totalCount / 2;
        int target = 0;

        int calCount = 0;

        int index1 = 0;
        int index2 = 0;

        int preValue = 0;

        while (calCount <= targetCount) {
            if (index2 >= nums2.length) {
                if (calCount != targetCount) {
                    preValue = nums1[index1];
                }
                target = nums1[index1];
                index1++;
                calCount++;
                continue;
            }
            if (index1 >= nums1.length) {
                if (calCount != targetCount) {
                    preValue = nums2[index2];
                }
                target = nums2[index2];
                index2++;
                calCount++;
                continue;
            }

            if (nums1[index1] < nums2[index2]) {
                if (calCount != targetCount) {
                    preValue = nums1[index1];
                }
                target = nums1[index1];
                index1++;
            } else {
                if (calCount != targetCount) {
                    preValue = nums2[index2];
                }
                target = nums2[index2];
                index2++;
            }
            calCount++;
        }

        if (totalCount % 2 == 0) {
            return (preValue + target) / 2.0;
        } else {
            return target;
        }
    }
}
