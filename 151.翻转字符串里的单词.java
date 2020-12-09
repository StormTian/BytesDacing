import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        int left = 0,right = s.length() - 1;
        //先处理前后的空白字符串
        while(left <= right && s.charAt(left) == ' ') {
            left ++;
        }
        while(left <= right && s.charAt(right) == ' ') {
            right --;
        }
        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        while(left <= right) {
            char c = s.charAt(left);
            if (word.length() > 0 && c == ' ') {
                d.offerFirst(word.toString());
                word.setLength(0);
            }else if (c != ' ') {
                word.append(c);
            }
            left ++;
        }
        d.offerFirst(word.toString());
        return String.join(" ", d);
    }
    // 效率较低
    // public String reverseWords(String s) {
    //     int len = s.length();
    //     if(len <= 1){
    //         return s;
    //     }
    //     List<String> strArr = new ArrayList<>();
    //     StringBuffer tmpBuffer = new StringBuffer();
    //     for(int i = 0; i < len; i ++) {
    //         if(s.charAt(i) == ' '){
    //             if(tmpBuffer.length() > 0){
    //                 strArr.add(tmpBuffer.toString());
    //                 tmpBuffer = new StringBuffer();
    //             }
    //             continue;
    //         }else {
    //             tmpBuffer.append(s.charAt(i));
    //         }
    //         if(i == len - 1 && tmpBuffer.length() > 0) {
    //             strArr.add(tmpBuffer.toString());
    //         }
    //     }
    //     StringBuffer ans = new StringBuffer();
    //     for(int j = strArr.size() - 1; j >= 0; j --){
    //         ans.append(strArr.get(j));
    //         if(j != 0){
    //             ans.append(' ');
    //         }
    //     }
    //     return ans.toString();
    // }
}
// @lc code=end

