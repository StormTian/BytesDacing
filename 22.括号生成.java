import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    ArrayList[] cache = new ArrayList[100];
    public List<String> generateParenthesis(int n) {
        return generate(n);
    }
    private List<String> generate(int n) {
        if(cache[n] != null){
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<String>();
        if(n == 0){
            ans.add("");
        }else {
            for(int i = 0; i < n; i ++) {
                for (String left : generate(i)) {
                    for (String right : generate(n - i - 1)) {
                        //核心分析逻辑
                        ans.add("("+ left+ ")"+ right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }
}
// @lc code=end

