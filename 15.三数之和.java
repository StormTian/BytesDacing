/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int first = 0; first < n; ++ first){//1号指针
            int third = n - 1;//从右往左的3号指针
            if(first > 0 && nums[first] == nums[first-1]){
                continue;
            }
            int target = -nums[first];
            for(int second = first + 1; second < n - 1; ++ second){//2号指针
                if(second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }//去重
                while(second < third && nums[second] + nums[third] > target){
                    third --;
                }
                if(second == third){
                    break;
                }
                if(nums[second] + nums[third] == target){
                    List<Integer> eureka = new ArrayList<Integer>();
                    eureka.add(nums[first]);
                    eureka.add(nums[second]);
                    eureka.add(nums[third]);
                    ans.add(eureka);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

