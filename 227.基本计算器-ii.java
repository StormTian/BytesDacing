import java.util.Stack;

/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();

        char lastOp = '+';
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i ++) {
            if(arr[i] == ' ') continue;
            if(Character.isDigit(arr[i])) {
                int tempNum = arr[i] - '0';
                while(++i < arr.length && Character.isDigit(arr[i])) {
                    tempNum = tempNum * 10 + arr[i] - '0';
                }i --;
                if(lastOp == '+') numStack.push(tempNum);
                else if(lastOp == '-') numStack.push(-1 * tempNum);
                else numStack.push(res(lastOp, numStack.pop(), tempNum));
            } else lastOp = arr[i];
        }
        int ans = 0;
        for(int num : numStack) ans += num;
        return ans;
    }
    //这个题因为没有括号的介入，所以可以将加减号前后的数字都看成独立的数字，最后只对乘除进行计算
    private int res(char op, int a, int b) {
        if(op == '*') return a * b;
        else  return a / b;
    }
}
// @lc code=end

