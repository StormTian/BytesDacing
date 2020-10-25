/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null){
            return "";
        }
        String prefix = strs[0];
        for(int i = 0; i < strs.length; i ++){
            prefix = longestCommonPrefixInTwo(prefix, strs[i]);
            if(prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }
    private String longestCommonPrefixInTwo(String pre, String compare){
        int index = 0;
        int length = Math.min(pre.length(), compare.length());
        while(index < length && pre.charAt(index) == compare.charAt(index)){
            index ++;
        }
        //substring的endIndex不包含
        return pre.substring(0, index);
    }
}
// @lc code=end

