/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char tmp =' ';
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while(left < right) {
            while(left < right && !vowels.contains(chars[left]+"")) {
                left ++;
            }
            while(left < right && !vowels.contains(chars[right]+"")) {
                right --;
            }
            tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp; 
            left ++;
            right --;
        }
        return String.valueOf(chars);
    }
    
}
// @lc code=end

