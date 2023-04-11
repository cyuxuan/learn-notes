
/**
 * 插入排序
 * @author chenyuxuan
 * @date 2022-01-05
 */
public class InsertionSort {

    public static void main(String[] args) {
        // 初始化测试数据
        Integer[] sources = {1,7,9,6};

        // 执行排序
        insertionSortDesc(sources);

        // 排序结束输出结果
        for(Integer item : sources) {
            System.out.print(item + "-");
        }
    }

    /**
     * 插入排序函数
     * @param sources 待排序数据
     */
    private static void insertionSortDesc(Integer[] sources) {
        // 记录当亲数组长度
        int length = sources.length;

        // 当前数据无需排序
        if(length <= 1) {
            // 放弃后续操作
            return;
        }
        // 执行排序
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if(sources[i] > sources[j] ) {
                    int item = sources[j];
                    sources[j] = sources[i];
                    sources[i] = item;
                }
            }
        }
    }
}