package com.mimu.simple.java.algorithm;

/**
 * 递归操作
 * 1.任何递归操作都可以转换成迭代(循环)的操作方式来实现,因为递归操作都是利用了计算机的入栈出栈的操作来实现的，所以使用迭代替换时 可自己模仿入栈出栈的动作 来实现
 * 2.对于T(N)=aT(N/b)+O(N^d) 其中a,b,d是常数，这类递归 其时间复杂度是确定的；
 * T(N) 表示 该类的递归行为 可以表示为  T(N/b) 子问题的规模是一致的(都是 N/b)并且被调用了a次，除了子问题被调用了a此外，剩下的复杂度可表示为 O(N^d)
 * 以 process 求数组最大值为例：T(N)=2T(N/2)+O(N^0) 子问题的规模为 N/2 且子问题process 被调用了 2 次，除此之外 剩下的复杂度 mid，Math.max() 的复杂度为 O(N^0)
 * <p>
 * 则 时间复杂度为
 * 如果： log(b^a)>d  O(N^log(b^a))
 * 如果： log(b^a)<d  O(N^d)
 * 如果： log(b^a)=d  O((N^d)*(log(N)))
 */
public class ClassicRecursion {


    /**
     * 求数组中的最大值
     * **************  f(0,3)
     * *************  /      \
     * ************  /        \
     * ********** f(0,1)      f(2,3)
     * *********  /  \         /  \
     * ********  /    \       /    \
     * ***** f(0,0) f(1,1)  f(2,2) f(3,3)
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    public int process(Integer[] array, int left, int right) {
        if (left == right) {
            return array[left];
        }
        int mid = left + ((right - left) >> 1);
        int leftProcess = process(array, left, mid);
        int rightProcess = process(array, mid, right);
        return Math.max(leftProcess, rightProcess);
    }

}
