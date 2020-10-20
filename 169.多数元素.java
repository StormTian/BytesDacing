/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {//分而治之，分别对局部的情况讨论之后再合并区间
    public int majorityElement(int[] nums) {
         return majorityElementUnit(nums, 0, nums.length - 1);
    }

    private int majorityElementUnit(int[] nums, int ls, int re){
        if(ls == re){
            return nums[ls];
        }
        int mid = ls + (re - ls) / 2;
        int left = majorityElementUnit(nums, ls, mid);
        int right = majorityElementUnit(nums, mid + 1, re);
        if(left == right){
            return left;
        }
        int leftCount = countInRange(nums, left, ls, mid);
        int rightCount = countInRange(nums, right, mid + 1, re);
        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int val, int start, int end){
        int count = 0;
        for(int i = start; i <= end; i ++){
            if(nums[i] == val){
                count ++;
            }
        }
        return count;
    }
}
// @lc code=end

