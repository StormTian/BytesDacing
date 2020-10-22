import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        Automation automation = new Automation();
        int length = s.length();
        for(int i = 0; i < length; i ++){
            automation.get(s.charAt(i));
        }
        return (int) (automation.sign * automation.ans);
    }
}
//有限状态自动机

class Automation {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>(){{
        //几种状态分别对应于：'',+/-,number,other
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
        }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if("in_number".equals(state)){
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if("signed".equals(state)){
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c){
         if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}
// @lc code=end

