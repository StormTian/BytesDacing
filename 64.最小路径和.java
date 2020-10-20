/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n][m];
        res[0][0] = grid[0][0];
        for(int i = 1; i < n; i ++){
            res[i][0] = res[i - 1][0] + grid[i][0];
        }
        for(int j = 1; j < m; j ++){
            res[0][j] = res[0][j - 1] + grid[0][j];
        }
        for(int i = 1; i < n; i ++){
            for(int j = 1; j < m; j ++){
                    res[i][j] =  Math.min(res[i - 1][j], res[i][j - 1])+ grid[i][j];
            }
        }
        return res[n - 1][m - 1];
    }
}
// @lc code=end

