/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        //双指针
        while(i < n){
            if(nums[i] == val){
                nums[i] = nums[n - 1];
                n --;
            }else{
                i ++;//只有当不相等的时候才会往后走
            }
        }
        return n;
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;//慢指针
        for(int j = 0; j < n; ++ j){//快指针
            if(nums[j] != val){
                nums[i] = nums[j];
                i ++;
            }
        }
        return i;
    }
}
// @lc code=end

