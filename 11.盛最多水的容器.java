/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        //双指针 
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while(l < r){
            int area = Math.min(height[l], height[r]) * (r - l); 
            ans = Math.max(ans, area);
            if(height[l] > height[r]){
                -- r;
            }else{
                ++ l;
            }
        }
        return ans;
    }
}
// @lc code=end

