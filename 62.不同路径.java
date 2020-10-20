/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        dp[0] = 1;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                if(j - 1 >= 0){
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[m - 1];
    }
}//空间复杂度为O(m*n)
// @lc code=end

