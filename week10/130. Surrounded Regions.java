public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if(m == 0) return;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0);
            }
            if(board[i][n-1] == 'O'){
                dfs(board, i, n-1);
            }
        }
        for(int i = 1; i < n - 1; i++){
            if(board[0][i] == 'O'){
                dfs(board, 0, i);
            }
            if(board[m-1][i] == 'O'){
                dfs(board, m-1, i);
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '1'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        board[i][j] = '1';
        for(int[] dir : directions){
            if(i+dir[0] >= 1 && i+dir[0] <= m - 2 && j+dir[1] >=1 && j+dir[1] <= n - 2){
                if(board[i+dir[0]][j+dir[1]] == 'O'){
                    dfs(board, i+dir[0], j+dir[1]);
                }
            }
        }
    }
}
