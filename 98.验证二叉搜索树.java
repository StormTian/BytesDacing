import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return false;
        }
        return judgeValidBST(root,null,null);
    }
    private boolean judgeValidBST(TreeNode root,Integer low,Integer high){
        if(root == null){
            return true;
        }
        int currVal = root.val;
        if(low != null && low >= currVal){
            return false;
        }
        if(high != null && high <= currVal){
            return false;
        }
        return judgeValidBST(root.left, low, currVal) && judgeValidBST(root.right, currVal, high);
    } 
}
//递归做法，即DFS，还可以用中序遍历读出来一个数组一定是升序数组
// @lc code=end

