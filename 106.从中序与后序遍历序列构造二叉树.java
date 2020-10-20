/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        indexMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i ++){
            indexMap.put(inorder[i], i);
        }
        TreeNode ans = myBuidTree(postorder, inorder, 0, n - 1, 0, n - 1);
        return ans;
    }
    private TreeNode myBuidTree(int[] postorder, int[] inorder, int postStart, int postEnd, int inStart,int inEnd){
        if(postStart > postEnd){
            return null;
        }
        int postRoot = postEnd;
        int inRoot = indexMap.get(postorder[postRoot]);
        int rightNum = inEnd - inRoot;
        TreeNode mytree = new TreeNode(postorder[postRoot]);
        mytree.left = myBuidTree(postorder, inorder, postStart, postRoot - rightNum - 1, inStart, inRoot - 1);
        mytree.right = myBuidTree(postorder, inorder, postRoot -rightNum , postRoot - 1, inRoot + 1, inEnd);
        return mytree;
    }
}
// @lc code=end

