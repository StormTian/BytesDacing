/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int length = s.length();
        if(length == 0 ) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        if(charArray[0] == '0'){
            return 0;
        }
        //dp[i]是s[i-1]结尾的解码方法数
        int[] dp = new int[length + 1];
        dp[0] = 1;
        //此处dp[0] = 1的原因是当前两位可作为2位数解码时，需要dp[0]作为一种状态量记载
        dp[1] = 1;
        for(int i = 1; i < length; i ++){
            if(charArray[i] != '0'){
                dp[i + 1] = dp[i];
            }
            int num = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
            if(num >= 10 && num <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[length];
    }
}
// @lc code=end


