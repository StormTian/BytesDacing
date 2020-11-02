/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String ans = countAndSay(n - 1);
        StringBuilder temp = new StringBuilder();
        int start = 0;
        for(int i = 1; i < ans.length() + 1; i ++){
            if(i == ans.length()){
                temp.append(i - start).append(ans.charAt(start));
            }else if(ans.charAt(i) != ans.charAt(start))
            {
                temp.append(i - start).append(ans.charAt(start));
                start = i;
            }
        }
        return temp.toString();
    }
}
// @lc code=end

