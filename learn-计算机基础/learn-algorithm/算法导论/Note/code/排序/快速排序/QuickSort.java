/**
 * 快速排序
 *
 * @author 陈玉轩
 * @date 2022-02-20
 */
public class QuickSort {

    public static void main(String[] args) {
        // 初始化数据
        Integer[] source = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        // 执行快速排序
        quickSort(source, 0, source.length - 1);

        // 打印结果
        System.out.println();
        for (Integer item : source) {
            System.out.print(","+item);
        }
        System.out.println();
    }

    /**
     * 快速排序
     *
     * @param A 排序数据
     * @param p 开始下标
     * @param r 结束下标
     */
    public static void quickSort(Integer[] A, int p, int r) {
        if (p < r) {
            // 将末尾位置的数放到正确位置上
            Integer q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    /**
     * 查找末尾数据在源数据中应该排在哪个位置，并将末尾位置的数放到正确位置上
     *
     * @param A 排序数据
     * @param p 开始下标
     * @param r 结束下标
     * @return 当前末尾数据在源数据中应该排序的位置
     */
    public static Integer partition(Integer[] A, int p, int r) {
        // 记录末尾数据
        Integer x = A[r];
        // 当前下标开始位置
        // i指向小于x的数的最后一个
        Integer i = p - 1;
        for (Integer j = p; j < r; j++) {
            if (A[j] < x) {
                i += 1;
                Integer tempA = A[i];
                A[i] = A[j];
                A[j] = tempA;
            }
        }
        // 将末尾位置的值交换到正确位置上
        Integer tempB = A[i + 1];
        A[i + 1] = A[r];
        A[r] = tempB;
        return i + 1;
    }
}
