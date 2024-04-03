package com.mimu.simple.java.leetcode;

import org.junit.Test;

/**
 * 岛屿数量
 * <p>
 * 二维数组中，每一个点都存在上，下，左，右，四个方向的相邻节点，使用深度优先遍历时，意味着对当前位置的，所有上，下，左，右四个方向进行访问；
 * <p>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */
public class LCTest_DFS_NumIsLands_200 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);// 将‘1’周边的‘1’修改为‘0’
                }
            }
        }
        return num_islands;
    }

    /**
     * 这里使用深度优先遍历，只要进入这个方法，退出的路径只有一个，那就是按规则(这里是上下左右)一条道走到黑，即当前节点的上下左右位置
     * 的数据都执行了一遍相同的操作后 本次进入的方法才能退出；在进行当前节点的上下左右访问过程中，对于访问到的数据，依然是上下左右的规则进行访问，
     * 而不是当前节点的上下左右四个访问操作全部执行完再执行下一个节点的上下左右；
     * 深度优先遍历，和递归序 完全一致，所以深度递归可以使用 递归来实现；
     *
     * 如二叉树的先序，中序，后续访问，就是一种深度遍历规则，规则为，先(根，左，右),中(左，根，右),后(左，右，根) 即对每一个子树都是这个规则，
     * 这里并不是把当前树进行先(根，左，右),中(左，根，右),后(左，右，根) 三个操作(这里的三个操作是确定某个序中的三个操作)全部执行完毕，
     * 在执行 下一个子树的 先(根，左，右),中(左，根，右),后(左，右，根)，而是在 先(根，左，右),中(左，根，右),后(左，右，根)这个规则执行的过程中，
     * 对访问到的节点也同样执行这个规则的访问；
     *
     * @param grid
     * @param r
     * @param c
     */
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';// 将当前位置的数据置 0，即改变当前位置元素值 这一操作
        dfs(grid, r - 1, c); // 当前位置的 上一个节点位置(平面上上一个位置) 同样执行相同的操作
        dfs(grid, r + 1, c); // 当前位置的 下一个节点位置(平面上下一个位置) 同样执行相同的操作
        dfs(grid, r, c - 1); // 当前位置的 左一个节点位置(平面上左一个位置) 同样执行相同的操作
        dfs(grid, r, c + 1); // 当前位置的 右一个节点位置(平面上右一个位置) 同样执行相同的操作
    }


    @Test
    public void numIslandResult() {
        char[][] metrix = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int i = numIslands(metrix);
        System.out.println(i);
    }
}
