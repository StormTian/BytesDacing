/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < n; ++ i){
            int start = i + 1;
            int end = n - 1;
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == target){
                    return target;
                }//有最最优解的情况下直接返回节约成本
                if(Math.abs(sum - target) < min){
                    min = Math.abs(sum - target);
                    ans = sum;
                }
                if(sum < target){
                    start ++;
                }else if(sum > target){
                    end --;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

