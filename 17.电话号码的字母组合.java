/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){return new ArrayList<>();};
        HashMap<Character,String> phoneMap = new HashMap<>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        StringBuilder temp = new StringBuilder();
        internalCombinations(digits, ans, temp, 0, phoneMap);
        return ans;
    }

    private void internalCombinations(String digits,List<String> ans,StringBuilder temp,int index, Map<Character,String> phoneMap){
        if(index == digits.length()){
            //在取完所有索引位后再加1，则最后回溯时index == length
            ans.add(temp.toString());
            return;
        }
        char currNum = digits.charAt(index);
        String letters = phoneMap.get(currNum);
        for(int i = 0; i < letters.length(); i ++){
            temp.append(letters.charAt(i));
            internalCombinations(digits, ans, temp, index + 1, phoneMap);
            temp.deleteCharAt(index);
        }
    }
}
// @lc code=end

