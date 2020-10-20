/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len < 1){
            return -1;
        }
        int l = 0;
        int r = len - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[l] <= nums[mid]){//左半边有序(注意边界的等号)
                if(target >= nums[l] && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{//右半边有序
                if(target <= nums[r] && target > nums[mid]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return - 1;
    }
}
// @lc code=end

