/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            ans ^= i;
        }
        return ans;
    }
}
/**
 * 正常的思路遍历一遍，用哈希表存储数字出现的次数，或者用另一个数组暂存数组中的数字
 * 异或运算的性质符合结合律，相同的数字异或为0，0和任何数字异或为数字本身
 */
// @lc code=end

