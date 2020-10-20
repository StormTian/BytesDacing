import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i ++){
            indexMap.put(inorder[i], i);
        }
        TreeNode ans = myBuidTree(preorder, inorder, 0, n - 1, 0, n - 1);
        return ans;
    }

    private TreeNode myBuidTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart,int inEnd){
        if(preStart > preEnd){
            return null;
        }
        int preRoot = preStart;
        int inRoot = indexMap.get(preorder[preRoot]);
        int leftNum = inRoot - inStart;
        TreeNode mytree = new TreeNode(preorder[preRoot]);
        mytree.left = myBuidTree(preorder, inorder, preRoot + 1, preRoot + leftNum, inStart, inRoot - 1);
        mytree.right = myBuidTree(preorder, inorder, preRoot + leftNum + 1, preEnd, inRoot + 1, inEnd);
        return mytree;
    }
}
// @lc code=end

