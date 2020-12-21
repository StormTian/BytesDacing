/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int add = 0;
        while(len1 >= 0 || len2 >= 0 || add != 0) {
            //一定会遇到某一个减完了，另一个还没减完的情况，所以需要处理
            int x = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int y = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            int result = x + y + add;
            sb.append(result % 10);
            add = result / 10;
            len1 --; len2 --;
        }
        return sb.reverse().toString(); 
    }
}
// @lc code=end

