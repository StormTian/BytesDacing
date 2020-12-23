/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for(int i = 2; i <= n; i ++){
            for(int j = 1; j <= i; j ++){
                G[i] += G[j - 1] * G[i - j];
            } 
        }
        return G[n];
    }   
    //95题的规律归纳，该题其实思路没错，就是找到0 1两项的情况进行动归即可
}
// @lc code=end

