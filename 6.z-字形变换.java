import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        ArrayList<StringBuffer> res = new ArrayList<>();
        for(int i = 0; i < Math.min(numRows, s.length()); i ++){
            res.add(new StringBuffer());
        } 
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            res.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : - 1;
        }
        StringBuffer ans = new StringBuffer();
        for(int i = 0; i < res.size(); i ++){
            ans.append(res.get(i));
        }
        return ans.toString();
    }
}
// @lc code=end

