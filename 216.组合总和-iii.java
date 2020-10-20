import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1,9,k,n);
        return ans;
    }

    private void dfs(int curr, int end, int k, int sum){
        if(temp.size() + end - curr + 1 < k || temp.size() > k){
            return;
        }
        if(temp.size() == k){
            int tempSum = 0;
            for (int num : temp) {
                tempSum += num;  
            }
            if(tempSum == sum){
                ans.add(new ArrayList<Integer>(temp));
                return;
            }
        }
        temp.add(curr);
        dfs(curr + 1, end, k, sum);
        temp.remove(temp.size() - 1);
        dfs(curr + 1, end, k, sum);
    }
}
// @lc code=end

