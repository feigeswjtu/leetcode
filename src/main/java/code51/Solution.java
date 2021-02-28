package code51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public List<List<String>> solveNQueens(int queensCount) {
        if (queensCount == 0) {
            return new ArrayList<>();
        }

        ArrayList<List<String>> result = new ArrayList<>(queensCount);
        if (queensCount == 1) {
            List<String> q = new ArrayList<>();
            q.add("Q");
            result.add(q);
            return result;
        }
        char[] baseValue = new char[queensCount];
        for (int i = 0; i < queensCount; i++) {
            baseValue[i] = '.';
        }

        List<MatrixLocation> putList = new ArrayList<>(queensCount);

        ArrayList<List<MatrixLocation>> midResult = new ArrayList<>(queensCount);

        // 回溯法
        dfs(queensCount, putList, midResult);

        for (List<MatrixLocation> matrixLocations : midResult) {
            List<String> list = new ArrayList<>(queensCount);
            for (MatrixLocation matrixLocation : matrixLocations) {
                char[] chars = Arrays.copyOf(baseValue, baseValue.length);
                chars[matrixLocation.getCol()] = 'Q';
                list.add(new String(chars));
            }

            result.add(list);
        }

        return result;
    }

    /**
     * 回溯法遍历
     *
     * @param queensCount
     * @param putList
     * @p aram totalCount
     */
    private void dfs(int queensCount, List<MatrixLocation> putList, ArrayList<List<MatrixLocation>> result) {
        for (int i = 0; i < queensCount; i++) {
            MatrixLocation currentLocation = new MatrixLocation();
            currentLocation.setRow(putList.size());
            currentLocation.setCol(i);

            if (!canHit(currentLocation, putList)) {
                putList.add(currentLocation);

                if (putList.size() == queensCount) {
                    result.add(new ArrayList<>(putList));
                    putList.remove(putList.size() - 1);
                    return;
                }

                dfs(queensCount, putList, result);
                putList.remove(putList.size() - 1);
            }
        }

    }

    /**
     * 判断是否可以攻击
     *
     * @param currentLocation
     * @param putList
     * @return
     */
    private boolean canHit(MatrixLocation currentLocation, List<MatrixLocation> putList) {
        for (MatrixLocation putLocation : putList) {
            int rowDistance = Math.abs(currentLocation.getRow() - putLocation.getRow());
            int colDistance = Math.abs(currentLocation.getCol() - putLocation.getCol());

            if (rowDistance == 0 || colDistance == 0 || rowDistance == colDistance) {
                return true;
            }
        }

        return false;
    }


}

/**
 * @author feigeswjtu.cyf
 * @version $Id: MatrixLocation.java, v 0.1 2021-02-07 11:08 feigeswjtu.cyf Exp $$
 */
class MatrixLocation {
    /**
     * 行
     */
    private int row;
    /**
     * 列
     */
    private int col;

    /**
     * Getter method for property row.
     *
     * @return property value of row
     */
    public int getRow() {
        return row;
    }

    /**
     * Setter method for property row.
     *
     * @param row value to be assigned to property row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Getter method for property col.
     *
     * @return property value of col
     */
    public int getCol() {
        return col;
    }

    /**
     * Setter method for property col.
     *
     * @param col value to be assigned to property col
     */
    public void setCol(int col) {
        this.col = col;
    }
}
