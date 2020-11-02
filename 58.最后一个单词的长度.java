/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int length = s.length();
        int res = 0;
        for(int i = length - 1; i >= 0; i --){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'z'){
                res ++;
            }else if(s.charAt(i) == ' ' && res != 0){
                break;
            }
        }
        return res;
    }
}
// @lc code=end

