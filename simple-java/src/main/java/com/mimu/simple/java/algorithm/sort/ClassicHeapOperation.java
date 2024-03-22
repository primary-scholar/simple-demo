package com.mimu.simple.java.algorithm.sort;


import java.util.Objects;

/**
 * 堆排序的思想：利用完全二叉树 堆数据进行排序 其过程分成两部分1.构建大根堆2.大根堆调整
 * ***************  T(1)
 * *************  /      \
 * ************  /        \
 * **********  T(2)       T(3)
 * *********  /  \         /  \
 * ********  /    \       /    \
 * *****  T(4)    T(5)  T(6)   T(7)
 * ****   /   \
 * ***  T(8)  T(9)
 * <p>
 * 对于数组下标i 的节点 其左子节点为 i*2,右子节点 i*2+1，其父节点 i/2;
 * 复杂度 O(N*logN)
 */

public class ClassicHeapOperation {

    /**
     * 堆排序
     * 空间复杂度 为 O(1)
     * 堆排序的过程 分为两个阶段
     * 1.构建大根堆；有两种方式1 一个元素一个元素的添加方式进行构建(向堆中添加一个元素是添加后的数据在整体上依然是一个堆)；
     * 2，一次给定一个数组 即多个元素的方式进行构建
     * 2.大根堆的调整；调整过程是把根元素和最有一个元素交换 然后在 heap[0]~heap[--heapSize]的范围内继续构建大根堆
     *
     * @param data
     */
    public void heapSort(Integer[] data) {
        if (Objects.isNull(data) || data.length < 2) {
            return;
        }
        /**
         * 堆构建
         */
        convert2Head(data);
        /**
         * 堆调整(排序)
         */
        sortHeap(data);
    }

    /**
     * 构造 大根堆 两种方式
     *
     * @param data
     */
    public void convert2Head(Integer[] data) {
        if (Objects.isNull(data) || data.length < 2) {
            return;
        }
        /**
         * 数组转换为 大根堆 方式 1 一次一个元素进行构建
         * 复杂度 O(N*logN)
         */
        for (int i = 0; i < data.length; i++) {//O(N)
            heapInsert(data, i);//O(logN) 从下向上(子节点和父节点比较-堆的节点越多(堆的高度越高)则比较交换的次数越多)
        }

        /**
         * 数组转换为 大根堆 方式 2 一次给定多个元素 进行构建
         * 复杂度 O(N) 没错的
         */
        for (int i = data.length - 1; i >= 0; i--) {
            heapFormat(data, i, data.length);//从上往下(父节点和子节点进行比较-堆的节点越多(堆的高度越高)则比较交换的次数越少)
        }
    }

    /**
     * 对大根堆 进行 调整 (排序)
     * 首先把大根堆的根(最大的数字)与最后一个元素交换，然后从根节点开始进行根的调整
     *
     * @param data
     */
    public void sortHeap(Integer[] data) {
        if (Objects.isNull(data) || data.length < 2) {
            return;
        }
        int headSize = data.length;
        swap(data, 0, --headSize);//根节点和最后一个节点交换
        while (headSize > 0) {
            heapFormat(data, 0, headSize);//堆调整
            swap(data, 0, --headSize);//每调整后的大根堆都和最后一个节点交换继续调整直到堆为空
        }
    }


    /**
     * 构建堆的过程 从下向上(子节点和父节点比较-堆的节点越多(堆的高度越高)则比较交换的次数越多) 逐渐堆化
     * index 当前最新添加的元素 即堆的最后一个元素
     * 从当前元素开始 依次和父几点元素 进行比较 若 > 父节点 则 交换
     * 当前节点 上移 到父节点的位置 继续进行比较
     *
     * @param data
     * @param index
     */
    private void heapInsert(Integer[] data, Integer index) {
        if (Objects.isNull(data)) {
            return;
        }
        // 当前节点和 父节点进行比较 若 > 则交换
        while (data[index] > data[(index - 1) / 2]) {
            swap(data, index, (index - 1) / 2);//交换当前节点和 父节点的元素
            index = (index - 1) / 2;//当前节点上移到父节点
        }
    }

    /**
     * 堆调整的过程 (某一个节点的调整) 全部堆的调整在 上层有个 for 循环
     * 从上往下(父节点和子节点进行比较-堆的节点越多(堆的高度越高)则比较交换的次数越少) 依次堆化
     * index 开始堆化的节点
     * 首先寻找 index 的左右子节点 并选择其中较大的一个 如果左右子节点的数字 > 当前节点 则交换
     * 当前 index 下移到 较大的子节点上 继续进行 寻找比对操作
     * 直到 左右子节点超过堆的大小 退出
     *
     * @param data
     * @param index
     * @param heapSize
     */
    private void heapFormat(Integer[] data, Integer index, Integer heapSize) {
        int left = index * 2 + 1;//获取当前节点的 左子节点
        while (left < heapSize) {//在 左节点 < 堆栈大小内循环
            //在左右子节点中选择一个较大的 下标 进行交换
            Integer swapIdx = left + 1 < heapSize && data[left + 1] > data[left] ? left + 1 : left;
            swapIdx = data[swapIdx] > data[index] ? swapIdx : index;
            if (swapIdx.equals(index)) {
                break;
            }
            // 当前节点和较大的子节点进行交换
            swap(data, swapIdx, index);
            index = swapIdx;//当前节点下移
            left = index * 2 + 1;//继续寻找当前节点的 左右子节点
        }
    }

    private void swap(Integer[] array, int i, int j) {
        if (Objects.isNull(array) || array.length <= 1) {
            return;
        }
        Integer tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 堆模型
     */
    public class CustomHeap {
        private Integer limit;
        private Integer heapSize;
        private Integer[] heap;

        public CustomHeap(Integer limit) {
            this.limit = limit;
            this.heapSize = 0;
            heap = new Integer[limit];
        }


        /**
         * 入堆 每添加一个元素 整个数组heap[0]~heap[heapSize]上依然符合堆的性质
         *
         * @param value
         */
        public void push(Integer value) {
            if (heapSize.equals(limit)) {
                throw new ArrayIndexOutOfBoundsException("heap is full");
            }
            heap[heapSize] = value;
            heapInsert(heap, heapSize++);
        }

        /**
         * 出堆 每删除一个元素 整个数组heap[0]~heap[heapSize]上依然符合堆的性质
         *
         * @return
         */
        public Integer pop() {
            if (heapSize.equals(0)) {
                throw new ArrayIndexOutOfBoundsException("heap is empty");
            }
            Integer value = heap[0];
            swap(heap, 0, --heapSize);
            heapFormat(heap, 0, heapSize);
            return value;
        }

    }

}
