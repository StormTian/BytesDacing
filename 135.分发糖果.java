/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if(len < 1) return 0;
        int[] candies = new int[len];
        candies[0] = 1;
        for (int i = 0; i < len - 1; i++) {
            if(ratings[i] < ratings[i + 1]){
                candies[i + 1] = candies[i] + 1;
            } else {
                candies[i + 1] = 1; //第一次遍历同步给数组元素置1
            }
        }
        int ans = candies[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]){
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            ans += candies[i]; //第二次遍历给ans递增结果
        }
        return ans;
    }
}
// @lc code=end

