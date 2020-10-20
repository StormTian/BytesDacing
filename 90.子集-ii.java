import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0, res);
        return res;
    }
    //类似于78题的思路 回溯
    private void dfs(int[] nums, List<Integer> temp, int start, List<List<Integer>> res){
        res.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; i ++){
            if(i > start && nums[i - 1] == nums[i]){
                continue;
            }
            temp.add(nums[i]);
            dfs(nums, temp, i + 1, res);
            temp.remove(temp.size() - 1);
        }
    }
}
// @lc code=end

