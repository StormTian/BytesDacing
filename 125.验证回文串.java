/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        int start = 0;
        int end = sb.length() - 1;
        boolean res = true;
        while(start < end){
            if(sb.charAt(start) != sb.charAt(end)){
                res = false;
                break;
            }
            start ++;
            end --;
        }
        return res;
    }
}
//该题三种思路：1、筛选后翻转比较 2n的空间复杂度 2、筛选后双指针 3、原地双指针
// @lc code=end

