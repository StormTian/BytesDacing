/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int length = needle.length();
        if(length == 0){
            return 0;
        }
        int pl = 0;
        while(pl < n - length + 1){
            int pr = 0;
            while(pr < length && pl < n && haystack.charAt(pl) == needle.charAt(pr)){
                pl ++;
                pr ++;
            }
            if(pr == length){
                return pl - length;
            }
            pl = pl - pr + 1;
        }
        return -1;
    }
}
// @lc code=end

