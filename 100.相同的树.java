import javax.swing.tree.TreeNode;

import apple.laf.JRSUIUtils.Tree;

/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) {
            if(p == null && q == null) {
                return true;
            }
            return false;
        }
        return isSame(p, q);
    }
    private boolean isSame(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        int pVal = p.val;
        int qVal = q.val;
        if(pVal != qVal) {
            return false;
        }
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}
//同理也是DFS，可以尝试理解一下BFS的做法
// @lc code=end

