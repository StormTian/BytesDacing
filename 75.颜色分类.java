/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        //三指针
        int head = 0;
        int end = nums.length - 1;
        int curr = 0;
        while(curr <= end){//不带等号会错过遍历一个end左移位于的元素
            if(nums[curr] == 0){
                int tmp = nums[curr];
                nums[curr ++] = nums[head];
                nums[head ++] = tmp;
            }else if(nums[curr] == 2){
                int tmp = nums[curr];
                nums[curr] = nums[end];
                nums[end --] = tmp;
            }else{
                curr ++;
            }
        }
    }
}
// @lc code=end

