import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    List<Integer> subset = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for(int mask = 0; mask < (1 << n); ++ mask){
            subset.clear();
            for(int i = 0; i < n; ++ i){
                if((mask & (1 << i)) != 0){
                    subset.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(subset));
            //这里需要新构造一个对象，引用类型的话，之后subset发生的变化都会改变ans中的值
        }
        return ans;
    }
}
// @lc code=end

