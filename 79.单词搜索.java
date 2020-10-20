/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
       int h = board.length, w = board[0].length;
       boolean[][] visited = new boolean[h][w];
       for(int i = 0; i < h; i ++){
           for(int j = 0; j < w; j ++){
            boolean flag = dfs(board, visited, word, i, j, 0);
            if(flag){
                return true;
            }
           }
       }
       return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int mask){
        if(word.charAt(mask) != board[i][j]){
            return false;
        }else if(mask == word.length() - 1){
            return true;
        }
        visited[i][j] = true;
        int[][] nextSteps = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for(int[] nextStep : nextSteps){
            int newi = i + nextStep[0];
            int newj = j + nextStep[1];
            if(newi >= 0 && newj >= 0 && newi < board.length && newj < board[0].length){
                if(!visited[newi][newj]){//此处需要判断该路径是否已经走过
                    boolean flag = dfs(board, visited, word, newi, newj, mask + 1);
                    if(flag){
                        result = true;
                        break;//此处在确定是真之后立刻break返回，否则会发生超时
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
// @lc code=end

