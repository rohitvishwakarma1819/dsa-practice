class Solution {
     public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new LinkedList<>();
         char[][] board = new char[n][n];
         for(int i=0;i<n;++i){
             Arrays.fill(board[i],'.');
         }
        solve(n,ans,board,0);
        return ans;
    }

    public void solve(int n, List<List<String>> ans, char[][] board,int row) {
        if (row == n){
            LinkedList<String> sol = new LinkedList<>();
            for(int i=0;i<n;++i){
                sol.add(String.valueOf(board[i]));
            }
            ans.add(sol);
            return;
        }
        for (int col = 0; col < n; ++col) {
           if(isValid(board,n,row,col)){
               board[row][col]='Q';
               solve(n,ans,board,row+1);
               board[row][col]='.';
           }
            
        }
    }
    
    public boolean isValid(char[][] board, int n, int r, int c){
        for(int i=0;i<n;++i){
            if(board[r][i] == 'Q')
                return false;
            if(board[i][c] == 'Q')
                return false;
        }
        
        int ir=r,ic=c;
        while(ir>=0 && ic<n){
            if(board[ir--][ic++] == 'Q')
                return false;
        }
        ir=r;ic=c;
        while(ir<n && ic>=0){
            if(board[ir++][ic--]=='Q')
                return false;
        }
        ir=r;ic=c;
        while(ir>=0 && ic>=0)
            if(board[ir--][ic--]=='Q')
                return false;
        ir=r;ic=c;
        while(ir<n&&ic<n)
            if(board[ir++][ic++]=='Q')
                return false;
        
        return true;
    }
    

}

// T-> O(N!xN)
// S-> O(N)
