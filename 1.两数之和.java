import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> cp = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            int key = target - nums[i];
            if(cp.containsKey(key) && cp.get(key) != i){
                return new int[]{cp.get(key), i};
            }
            cp.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
// @lc code=end

