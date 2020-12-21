/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        int ans = 0;
        int length = s.length();
        for(int i = 0; i < length; i ++){
            if((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' '){
                ans ++;
            }
            // ||这个或执行完前面的直接不执行后面的，然后是识别到空格后的非空格字符就先加1，之前做的是字符结束后加
        }
        return ans;
    }
}
// @lc code=end

