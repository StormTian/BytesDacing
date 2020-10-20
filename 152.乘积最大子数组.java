/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        int curMax = nums[0];
        int curMin = nums[0];
        int ans = nums[0];
        for(int i = 1; i < len; i ++){
            //只需要保存i和i-1两种情况作滚动数组，第一个元素通过初始化已经置好了
            int mx = curMax;
            int mn = curMin;
            curMax = Math.max(mx * nums[i], Math.max(nums[i], nums[i] * mn));
            curMin = Math.min(mn * nums[i], Math.min(nums[i], nums[i] * mx));
            ans = Math.max(curMax, ans);
        }
        return ans;
    }
}
// @lc code=end

