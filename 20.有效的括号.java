import java.util.Deque;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if(len % 2 == 1){
            return false;
        }
        Map<Character,Character> colMap = new HashMap<>(){{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for(int i = 0; i < len; i ++){
            char c = s.charAt(i);
            if(colMap.containsKey(c)){
                if(stack.isEmpty() || stack.peek() != colMap.get(c)){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

