import java.util.Objects;

/**
 * 堆排序
 *
 * @author 陈玉轩
 * @date 2022-02-09
 */
public class HeapSort {

    /**
     * 记录在执行堆性质维护时当前最大的元素的下标
     */
    private static Integer largest = -1;

    public static void main(String[] args) {
        // 初始化排序数据
        Integer[] source = {1, 2};
        Heap heap = new Heap();
        heap.A = source;
        heap.buildMaxHeap(heap);
    }


    private static class Heap {
        /**
         * 当前堆元素
         */
        public Integer[] A;

        /**
         * 当前堆大小
         */
        public Integer heapSize;


        /**
         * 获取当前元素的父元素
         *
         * @param index 当前元素
         * @return 父元素
         */
        private static Integer parent(Integer index) {
            return index >> 2;
        }

        /**
         * 获取当前节点左孩子下标
         *
         * @param index 当前节点
         * @return 目标节点
         */
        private static Integer leftSon(Integer index) {
            return index << 2;
        }

        /**
         * 获取当前节点右孩子下标
         *
         * @param index 当前节点
         * @return 右孩子节点
         */
        private static Integer rightSon(Integer index) {
            return index << 2 + 1;
        }


        /**
         * 维护最大堆性质
         *
         * @param heap  当前堆数组
         * @param index 当前下标位置
         */
        private static void maxHeapify(Heap heap, Integer index) {
            // 获取左下标
            Integer left = leftSon(index);
            // 获取右下标
            Integer right = rightSon(index);
            // 如果左孩子大于右孩子，则记录当前最大值的下标，否则需要对比根和右孩子，所以将largest重置为根的下标
            if (left <= heap.heapSize && heap.A[left] > heap.A[largest]) {
                largest = left;
            } else {
                largest = index;
            }
            // 如果右孩子大于左孩子则，将右孩子下标置为最大值下标
            if (right < heap.heapSize && heap.A[right] > heap.A[largest]) {
                largest = right;
            }
            // 找到最大节点后，调换根节点与最大节点的值
            if (!Objects.equals(largest, index)) {
                Integer tempNum = heap.A[index];
                heap.A[index] = heap.A[largest];
                heap.A[largest] = tempNum;

                // 再次维护堆的性质
                maxHeapify(heap, largest);
            }
        }

        /**
         * 建堆
         *
         * @param heap 当前堆数据
         */
        private void buildMaxHeap(Heap heap) {
            heap.heapSize = heap.A.length;
            for (int i = heap.A.length / 2; i > 0; i--) {
                maxHeapify(heap, i);
            }
        }

        /**
         * 堆排序算法
         *
         * @param heap 堆
         */
        private void heapSort(Heap heap) {
            // 建成最大堆
            buildMaxHeap(heap);
            // 执行排序
            for (int i = heap.A.length; i > 0; i--) {
                // 交换A[1]与A[i]的值，A[1]中存的一直都是最大值，
                // 要将它与最后一个元素交换，重新排序剩余元素
                Integer tempNum = heap.A[i];
                heap.A[i] = heap.A[1];
                heap.A[1] = tempNum;
                // 减少堆中元素个数记录
                heap.heapSize--;
                // 自底向上堆排序
                maxHeapify(heap, 1);
            }
        }

        /**
         * 返回最大值
         *
         * @param heap 当前堆
         * @return 最大值
         */
        private Integer heapMaxMum(Heap heap) {
            return heap.A[1];
        }

        /**
         * 堆提取最大值
         *
         * @param heap 当前堆
         * @throws Exception 异常信息
         */
        private void heapExtractMax(Heap heap) throws Exception {
            if (heap.heapSize < 1) {
                throw new Exception("error underflow");
            }
            Integer max = A[1];
            heap.A[1] = heap.A[heap.heapSize];
        }

        /**
         * 增加元素
         *
         * @param heap  当前堆
         * @param index 加入的下标
         * @param key   当前关键字（值）
         * @throws Exception 异常信息
         */
        private void heapIncreaseKey(Heap heap, Integer index, Integer key) throws Exception {
            if (key < A[index]) {
                throw new Exception("new key is samller than current key");
            }
            heap.A[index] = key;
            while (index > 1 && Heap.parent(index) < heap.A[index]) {
                // 交换
                Integer tempNum = heap.A[index];
                heap.A[index] = heap.A[parent(index)];
                heap.A[parent(index)] = tempNum;

                index = parent(index);
            }
        }

        /**
         * 插入新的值
         *
         * @param heap 当前堆
         * @param key  关键字（值）
         * @throws Exception 异常信息
         */
        private void maxHeapInsert(Heap heap, Integer key) throws Exception {
            heap.heapSize++;
            heap.A[heap.heapSize] = Integer.MIN_VALUE;
            heapIncreaseKey(heap, heap.heapSize, key);
        }

    }
}
