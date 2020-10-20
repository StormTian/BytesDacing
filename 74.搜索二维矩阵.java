
/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //矩阵的二分法 还是NB啊
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            int midVal = matrix[mid / n][mid % n];
            if(target == midVal){
                return true;
            }else if(target > midVal){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
// @lc code=end

