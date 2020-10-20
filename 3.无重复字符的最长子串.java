import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int end = 0;
        int ans = 0;
        int n = s.length();
        HashSet<Character> tempSet = new HashSet<>();
        for(int i = 0; i < n; i ++){
            if(i != 0){
                tempSet.remove(s.charAt(i - 1));
            }
            while(end < n && !tempSet.contains(s.charAt(end))){
               tempSet.add(s.charAt(end));
               end ++;
            }
            ans = Math.max(ans, end - i);
        }
        return ans;
    }
}
// @lc code=end

