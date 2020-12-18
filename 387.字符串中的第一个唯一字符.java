import java.awt.List;
import java.util.HashMap;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) {
            return -1;
        }
        HashMap<Character,Integer> kMap = new HashMap<>();
        List<Integer> uniqPositions = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(kMap.containsKey(c)) {
                Integer position = kMap.get(c);
                uniqPositions.remove(position);
                //list的remove方法可以传入index也可以传入元素，集合只能使用包装类型
            }else {
                kMap.put(c, i);
                uniqPositions.add(i);
            }
        }
        return uniqPositions.isEmpty() ? -1 : uniqPositions.get(0);
    }
}
// @lc code=end

