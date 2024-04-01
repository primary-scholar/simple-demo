package com.mimu.simple.java.algorithm.sort;


import com.mimu.simple.java.algorithm.recursion.ClassicRecursion;

import java.util.Objects;

/**
 * 随机快排
 * <p>
 * <p>
 * partition过程
 * p1 把数组分成两块 case：在数组 把 <= a number 得数排在 该数的左边，> 该数的数 排在该数的 右边
 * p2 把数组分成3块 case: 在数组 把 < a number 得数放在 左侧，= 该数的数 放在中间 ，> 该数的数 放在 右边
 * <p>
 * 快排思想：
 */
public class ClassicSortOfAnotherNum extends ClassicRecursion {

    /**
     * p1 返回 <= 区的 右边界
     * 以 array[right] 作为候选数据
     * > 候选数 的数排在 右侧 <=array[right] 的排在左侧
     * 整体思想：初始时 把数组分成两部分，<=区为 (array[0],array[left-1]),>区为 (array[left],array[right])两部分 即 <=区 在左边，>区 在右边
     * 初始时 left=0即初始时把数组分为两部分array[-1],arry[0,right]两部分，即<=区，在数组之外
     * 在 < 区域的右边界的下一个 和 数组的 right 边界内循环
     * 如果 array[idx]<= 候选数 即该元素应该在左侧 则把当前元素和 <= 区的 下一个元素交换，即 <= 区 不停的向右移
     * idx++
     * 当 idx > right 时 退出循环
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    public Integer partition1Idx(Integer[] array, Integer left, Integer right) {
        if (left > right) {
            return -1;
        }
        if (left.equals(right)) {
            return left;
        }
        //初始 把数组分成两块 <= 区和>区，<=区为 (array[0],array[left-1]),>区为 (array[left],array[right])两部分 并从 left 开始循环
        int le = left - 1, idx = left;
        // 从 left 到 right 开始循环
        while (idx < right) {
            // 如果当前元素 <= 候选数 则  把当前元素和 <=区的下一个元素进行交换
            if (array[idx] <= array[right]) {
                swap(array, idx, ++le);//++le 即<=区 不断右扩
            }
            idx++; // 当前 下标 ++
        }
        swap(array, ++le, right); // 把 候选数 和 < 区域的右边界 的下一个 进行交换，
        return le;
    }

    /**
     * p2 返回 < 区 和 >区 两侧边界
     * 以 array[right] 作为候选数据 把 < array[right] 的数据 排在左侧，==array[right] 的数据放在中间,> array[right] 的放在右侧
     * 整体思路：初始把数组分成 三块 array[left-1],array[left,right],array[right] 即 > 区域初始时是 包含array[right]的
     * <p>
     * 在 < 区域 右边界 和 >区域 左边界 内循环
     * 如果 array[idx] == 候选数 则 idx++
     * 如果 array[idx] < 候选数 则 把 当前下标的数 和 < 区域的下一个数 进行交换 idx 后移
     * 如果 array[idx] > 候选数 则 把 当前下标的数 和 > 区域的前一个数 进行交换 idx 不动,因为此时 被交换过来的 数 array[idx] 还没有和 候选数 进行比较
     * <p>
     * 直到 idx > 区域的 下标时 退出 循环
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    public Integer[] partition2Idx(Integer[] array, Integer left, Integer right) {
        if (left > right) {
            return new Integer[]{-1, -1};
        }
        if (left.equals(right)) {
            return new Integer[]{left, right};
        }
        //初始 把数组分成三 块 < 区 array[left-1], = 区 array[left,right-1]  >区 array[right] 并从 left 开始循环
        int le = left - 1, gt = right, idx = left;
        // idx 没有和 > 区 相交时 循环
        while (idx < gt) {
            // 如果相等 则 idx++
            if (Objects.equals(array[idx], array[right])) {
                idx++;
            } else if (array[idx] < array[right]) {// 如果 array[idx] < 候选数 则 array[idx]和 < 区的下一个元素 交换 且 idx++
                swap(array, idx++, ++le);// ++le 即 < 区的下一个元素
            } else { //如果 array[idx] > 候选数 则 array[idx]和 > 区的前一个元素 交换
                swap(array, idx, --gt);//--gt > 区的前一个元素 且 idx 不动
            }
            swap(array, gt, right);//最后一个 候选数 和 > 区的 最前一个元素 进行交换 即可
        }
        return new Integer[]{le + 1, gt};
    }


    /**
     * 快排
     *
     * @param array
     */
    public void quickSort(Integer[] array) {
        quickPartition(array, 0, array.length - 1);
    }

    /**
     * 快排 递归算法
     * 在待排序的数据中随机选择一个数字 然后进行 partition 操作 把 < 该数的 数字放在 该数的左侧，>该数的数据放在该数的 右侧
     * 经过该操作后就把整体数据 分成了 两块
     * 然后在 array[0] 和 随机选择的数据区域 继续进行 partition 操作,
     * 同样在 随机选择的数据 和 array[array.length-1] 的区域 继续进行 partition 操作
     * 直到 左右子规模的 长度 = 1 即可退出
     *
     * @param array
     * @param left
     * @param right
     */
    private void quickPartition(Integer[] array, Integer left, Integer right) {
        // 左右子规模何时可退出 即 子规模的长度 =1 时 可退出
        if (left >= right) {
            return;
        }
        // 在待排序的数据中 进行 partition 操作 即 把数据 分成 两块
        Integer part = partition1Idx(array, left, right);
        // 在左子规模区域 继续进行 partition 操作
        quickPartition(array, left, part - 1);
        // 右子规模区域 进行 partition 操作
        quickPartition(array, part + 1, right);
    }

    private void swap(Integer[] array, int i, int j) {
        if (Objects.isNull(array) || array.length <= 1) {
            return;
        }
        Integer tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
