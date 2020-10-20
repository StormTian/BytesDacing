import java.util.List;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        int pre = 1;
        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        for(int i = 1; i <= rowIndex ; i ++){
            for(int j = 1; j < i; j ++){
                int temp = curr.get(j);
                curr.set(j, pre + curr.get(j));
                pre = temp;
            }
            curr.add(1);
        }
        return curr;
    }
}
// @lc code=end

