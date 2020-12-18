/*
 * @lc app=leetcode.cn id=385 lang=java
 *
 * [385] 迷你语法分析器
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    char[] charArr;
    int curr = 0;
    public NestedInteger deserialize(String s) {
        charArr = s.toCharArray();
        if(charArr[0] != '[') return new NestedInteger(Integer.valueOf(s));
        return getNest();
    }

    public NestedInteger getNest() {
        NestedInteger nest = new NestedInteger();
        int num = 0;
        int sigh = 1;
        while(curr < charArr.length - 1) {
            curr ++;
            if(charArr[curr] == ',') continue;
            if(charArr[curr] == '[') nest.add(getNest());
            //原先错误的地方在这里，理清楚只有在遇到右中括号的时候，才会去返回nest，左中括号是把下钻的对象添加到当前的nest
            else if(charArr[curr] == ']') return nest;
            else if(charArr[curr] == '-') sigh = -1;
            else{
                num = num * 10 + (charArr[curr] - '0') * sigh;
                if(charArr[curr + 1] == ',' || charArr[curr + 1] == ']'){
                    nest.add(new NestedInteger(num));
                    num = 0;
                    sigh = 1;
                }
            }
        }
        return null;
    }
}

// @lc code=end

