package aother.sort;

/**
 * 快速排序算法
 * 复杂度: Q(n*log(n))
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class QuickSort implements ISort {
    private int[] data;

    /**
     * 排序
     *
     * @param data
     * @return
     */
    @Override
    public int[] sort(int[] data) {
        this.data = data;
        quickSort(0, data.length - 1);
        return this.data;
    }

    /**
     * 快速排序
     *
     * @param startIndex
     * @param endIndex
     */
    private void quickSort(int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int i = partition(startIndex, endIndex);

        quickSort(startIndex, i - 1);
        quickSort(i + 1, endIndex);
    }

    /**
     * 分区排序
     *
     * @param startIndex
     * @param endIndex
     * @return
     */
    private int partition(int startIndex, int endIndex) {
        int i = startIndex;
        int j = endIndex;
        int tmp = data[i];

        while (i < j) {
            //从右边开始移动的原因是左边第一个是关键值，肯定不会大于关键值
            while (data[j] >= tmp && i < j) {
                j--;
            }
            data[i] = data[j];
            while (data[i] <= tmp && i < j) {
                i++;
            }
            data[j] = data[i];
        }
        data[i] = tmp;
        return i;
    }
}
