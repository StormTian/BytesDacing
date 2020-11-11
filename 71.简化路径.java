import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String item : path.split("/")) {
            if(item.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!item.isEmpty() && !item.equals(".")){
                stack.push(item);
            }
        }
        String res = "";
        for (String string : stack) {
            res = "/" + string + res;
        }
        return res.isEmpty() ? "/" : res;
    }
}
/**
 * 用栈来做，牛逼 记得Java判断字符串内容相等要用equals
 * 最后返回的时候，就从后往前拼返回的res字符串即可
 */
// @lc code=end

