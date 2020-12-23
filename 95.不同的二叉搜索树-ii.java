import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<TreeNode>();
        }
        return generateTree(1, n);
    }
    private List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if(start > end){
            allTrees.add(null);
            return allTrees;
        }
        for(int i = start; i <= end; i ++){
            List<TreeNode> leftList = generateTree(start, i - 1);
            List<TreeNode> rightList =generateTree(i + 1, end);
            for (TreeNode lNode : leftList) {
                for (TreeNode rNode : rightList) {
                    TreeNode curNode = new TreeNode(i);
                    curNode.left = lNode;
                    curNode.right = rNode;
                    allTrees.add(curNode);
                }
            }  
        }
        return allTrees;
    }
    //二叉搜索树的特点是根的左子树值都小于根，右子树值都大于根，所以将问题按区间分治思路进行处理
}
// @lc code=end

