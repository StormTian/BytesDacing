
/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];
        for(int i = 0; i < magazine.length(); i ++) {
            record[magazine.charAt(i) - 'a'] ++;
        }
        for(int j = 0; j < ransomNote.length(); j ++) {
            record[ransomNote.charAt(j) - 'a'] --;
            if(record[ransomNote.charAt(j) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
//哈希的思想，只维护一个数组来存字符串中每一个字母的出现次数，复杂度为O(M+N)
// @lc code=end

