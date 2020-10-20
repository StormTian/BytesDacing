/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        while(i >= 0 && j >= 0){
            nums1[i + j + 1] = nums2[j] >= nums1[i] ? nums2[j --] : nums1[i --];  
        }
        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }
}
// @lc code=end

