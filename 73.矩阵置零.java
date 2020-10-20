/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rows = new int[m];
        int[] columns = new int[n];
        for(int i = 0; i < m; ++ i){
            for(int j = 0; j < n; ++ j){
                if(matrix[i][j] == 0){
                    rows[i] = 1;
                    columns[j] = 1;
                }
            }
        }
        for(int i = 0; i < m; ++ i){
            if(rows[i] == 1){
                for(int j = 0; j < n; ++ j){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 0; j < n; ++ j){
            if(columns[j] == 1){
                for(int i = 0; i < m; ++ i){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
// @lc code=end

