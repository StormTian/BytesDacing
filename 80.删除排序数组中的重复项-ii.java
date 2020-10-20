/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除排序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        //想到了用一个count去作为判重指针，但是没想到再弄一个j作为慢指针
        int count = 1; int j = 1;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] == nums[i - 1]){
                count ++;
            }else{
                count = 1;
            }
            if(count <= 2){
                nums[j ++] = nums[i];
            }
        }
        return j;
    }
}
// @lc code=end

