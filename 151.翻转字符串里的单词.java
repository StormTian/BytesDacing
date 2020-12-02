import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        if(len <= 1){
            return s;
        }
        List<String> strArr = new ArrayList<>();
        StringBuffer tmpBuffer = new StringBuffer();
        for(int i = 0; i < len; i ++) {
            if(s.charAt(i) == ' '){
                if(tmpBuffer.length() > 0){
                    strArr.add(tmpBuffer.toString());
                    tmpBuffer = new StringBuffer();
                }
                continue;
            }else {
                tmpBuffer.append(s.charAt(i));
            }
            if(i == len - 1 && tmpBuffer.length() > 0) {
                strArr.add(tmpBuffer.toString());
            }
        }
        StringBuffer ans = new StringBuffer();
        for(int j = strArr.size() - 1; j >= 0; j --){
            ans.append(strArr.get(j));
            if(j != 0){
                ans.append(' ');
            }
        }
        return ans.toString();
    }
}
// @lc code=end

