import jdk.nashorn.internal.ir.IdentNode;

/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return false;
        }
        int left = 0;
        int right = len - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[left] < nums[mid]){
                //左边的数组有序
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }else if(nums[left] > nums[mid]){
                //右边的数组有序
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid;
                }else{
                    right = mid - 1;
                }
            }else{
                if(nums[left] == target){
                    return true;
                }else{
                    left ++;
                }
            }
        }
        return nums[right] == target ? true : false;
    }
}
// @lc code=end

