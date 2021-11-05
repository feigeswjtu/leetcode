package aother.other;

import java.text.ParseException;
import java.util.Scanner;

/**
 * 矩阵中最大正方形面积
 *
 * @author feigeswjtu.cyf
 * @version $Id: other.Main1.java, v 0.1 2021-03-13 21:59 feigeswjtu.cyf Exp $$
 */
public class Main2 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        if (rows == 0) {
            System.out.println(0);
            return;
        }

        scanner.nextLine();

        int[][] nums = new int[rows][];
        int inputCount = 0;
        while (inputCount < rows) {
            String line = scanner.nextLine();
            int[] data = new int[line.length()];
            for (int i = 0; i < line.length(); i++) {
                data[i] = (int) (line.charAt(i) - '0');
            }
            nums[inputCount] = data;
            inputCount++;
        }

        int length = searchMatrix(nums);
        System.out.println(length * length);
    }

    /**
     * 顾客个数
     *
     * @param matrix
     * @return
     */
    private static int searchMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int[][] matrixTemp = new int[matrix.length][matrix[0].length];
        int rows = matrix.length;
        int cols = matrix[0].length;
        int mix = 0;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 1) {
                mix = 1;
                matrixTemp[i][0] = 1;
            }
        }

        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 1) {
                mix = 1;
                matrixTemp[0][i] = 1;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    int min = matrixTemp[i][j - 1];
                    min = Math.min(min, matrixTemp[i - 1][j]);
                    min = Math.min(min, matrixTemp[i - 1][j - 1]);
                    matrixTemp[i][j] = min + 1;
                } else {
                    matrixTemp[i][j] = 0;
                }
                mix = Math.max(mix, matrixTemp[i][j]);
            }
        }


        return mix;
    }
}
