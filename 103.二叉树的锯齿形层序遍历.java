/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean isFromLeft = true;
        while(! queue.isEmpty()){
            int currentSize = queue.size();
            Deque<Integer> deque = new LinkedList<>();
            for(int i = 1;i <= currentSize; i ++){
                TreeNode node = queue.poll();
                if(isFromLeft) {
                    deque.addLast(node.val);
                } else {
                    deque.addFirst(node.val);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            ret.add(new ArrayList<Integer>(deque));
            isFromLeft = !isFromLeft;
        }
        return ret;
    }
}
// @lc code=end

