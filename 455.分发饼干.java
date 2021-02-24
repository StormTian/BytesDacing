import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cookies = 0;
        int kids = 0;
        while(cookies < s.length && kids < g.length){
            if(g[kids] <= s[cookies]) kids++;
            cookies++;
        }
        return kids;
    }
}
// @lc code=end

