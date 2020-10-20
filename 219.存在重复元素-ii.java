import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 */

// @lc code=start
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> valMap = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            if(valMap.containsKey(nums[i]) && i - valMap.get(nums[i]) <= k){
                return true;
            }
            valMap.put(nums[i], i);
        }
        return false;
    }
}
// @lc code=end

