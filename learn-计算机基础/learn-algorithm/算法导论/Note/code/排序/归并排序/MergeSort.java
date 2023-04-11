
/**
 * @author 陈玉轩
 * @date 2022-01-10
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        // 初始化数据
        int[] sources  = {5,8,6,8,7,3,6,5,6,4};

        // 归并排序
        toMergeSort(sources);

        // 输出数据
        for(int item : sources) {
            System.out.print(item + "-");
        }
    }

    private static void toMergeSort(int[] sources) {
        // 获取当前数据长度
        int length = sources.length;

        // 如果当前数据小于1则不需要排序
        if(length <= 1) {
            // 放弃后续操作
            return;
        }

        // 否则执行归并排序
        mergeSort(sources, 0, sources.length - 1);
    }

    /**
     * 归并排序
     * @param sources 待排序数据
     * @param start 开始下表-第一个归并段开始位置
     * @param end 结束下表-第二个归并段结束位置
     */
    private static void mergeSort(int[] sources, int start, int end){
        if(start >= end)
            return;
        // 取当前区间中间值
        int mid = (start + end) / 2;
        // 归并前一半
        mergeSort(sources, start, mid);
        // 归并后一半
        mergeSort(sources, mid + 1, end);
        // 归并当前区间
        merge(sources, start, mid, end);
    }

    /**
     * 执行归并
     * @param sources 待归并数据
     * @param start 开始下表-第一个归并段开始位置
     * @param mid 中间下标-第一个归并段开始位置且是第二个归并段结束位置
     * @param end 结束下表-第二个归并段结束位置
     */
    private static void merge(int[] sources, int start, int mid, int end) {
        // 计算第一个归并段的数量
        int num1 = mid - start + 1;
        // 计算第二个归并段的数量
        int num2 = end - mid;
        // 重新赋值归并串
        int[] leftPart = new int[num1 + 1];
        for(int i= 0 ; i < num1 ;  i++) {
            leftPart[i] = sources[start + i];
        }
        leftPart[num1] = Integer.MAX_VALUE;
        int[] rightPart = new int[num2 + 1];
        for(int i= 0 ; i < num2 ;  i++) {
            rightPart[i] = sources[mid + 1 + i];
        }
        rightPart[num2] = Integer.MAX_VALUE;
        // 执行归并
        int l = 0;
        int r = 0;
        for(int k =  start; k <= end; k++) {
            if(leftPart[l] <= rightPart[r]) {
                sources[k] = leftPart[l];
                l++;
            } else {
                sources[k] = rightPart[r];
                r++;
            }
        }
    }
}
