/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < len - 2; i ++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j < len - 1; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int start = j + 1;
                int end = len - 1;
                while(start < end){
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if(sum == target){
                        List<Integer> eureka = new ArrayList<>();
                        eureka.add(nums[i]);
                        eureka.add(nums[j]);
                        eureka.add(nums[start]);
                        eureka.add(nums[end]);
                        ans.add(eureka);
                        while(start < end && nums[start] == nums[start + 1]){
                            start ++;
                        }//出现重复解去重
                        start ++;
                        end --;
                    }else if(sum > target){
                        end --;
                    }else{
                        start ++;
                    }
                }  
            }
        }
        return ans;
    }
}
// @lc code=end

