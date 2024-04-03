package com.mimu.simple.java.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 矩阵的螺旋访问
 * <p>
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * * 1->2->3
 * *       |
 * * 4->5  6
 * * |     |
 * * 7<-8<-9
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * <p>
 * 注意：
 * 这里不能使用 dfs 因为如果要套用 dfs的话，那我们定义的规则就是 右，下，左，上；这里对于 4*3的矩阵
 * 如  1**2**3
 * *   4**5**6
 * *   7**8**9
 * *   10*11*12
 * 访问顺序就会是 蛇形走位了 就是 1->2->3->6->9->12->11->10->7->8->5->4 这里并不是 循环访问了
 * 因为 dfs 对于访问到的每一个元素都是 按照 右，下，左，上的顺序进行访问的，
 * 这里访问到10后，其访问过程如下：
 * 再次向右 访问 11 因为访问过，返回
 * 再次向下 访问 num[4][0](10下面的元素) 因为越界 返回
 * 再次向左 访问 num[4][-1](10左边的元素) 因为越界 返回
 * 再次向上 访问 7 可以访问 这里访问到7后 会再次按照 右，下，左，上的规则 进行访问，所以这里就不符合螺旋访问的 顺序了；
 */
public class LCTest__SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        ArrayList<Integer> result = new ArrayList<>();
        /**
         * 这里的方向数组 分别表示 i,j的增量如
         * 向右 即 i+0,j+1 即数组第一个
         * 向下 即 i+1,j+0 即数组第二个
         * 向左 即 i+0,j-1 即数组第三个
         * 向上 即 i-1,j+0 即数组第四个
         */
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0, j = 0, dir = 0;
        Boolean[][] visited = new Boolean[row][column]; // 记录当前位置已被访问过
        for (int idx = 0; idx < row * column; idx++) {
            result.add(matrix[i][j]);
            visited[i][j] = Boolean.TRUE;
            int x = i + direction[dir][0]; // 即 row 的变换策略
            int y = j + direction[dir][1]; // 即 column 的变换策略
            if (x < 0 || x >= row || y < 0 || y >= column || visited[x][y] == Boolean.TRUE) {
                dir = (dir + 1) % 4; // 转变 步长调整 策略
                x = i + direction[dir][0]; // 即 row 的变换策略
                y = j + direction[dir][1]; // 即 column 的变换策略
            }
            i = x;
            j = y;
        }
        return result;
    }


    @Test
    public void spiralOrderResult() {
        List<Integer> integers1 = spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        System.out.println(integers1);
    }

}
