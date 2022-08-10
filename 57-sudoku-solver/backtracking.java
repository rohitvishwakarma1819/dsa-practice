class Solution {
    public void solveSudoku(char[][] board) {
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] unit = new HashSet[9];
        init(row);
        init(col);
        init(unit);
        
        for(int i=0;i<9;++i){
            for(int j=0;j<9;++j){
                if(board[i][j]!='.'){
                    char c = board[i][j];
                    row[i].add(c);
                    col[j].add(c);
                    unit[getIndex(i,j)].add(c);
                }
            }
        }
        solve(board,row,col,unit,0);
        
        
    }
    
    public boolean solve(char[][] board, HashSet<Character>[] rows,HashSet<Character>[] cols, HashSet<Character>[] units, int index){
        if(index>=81)
            return true;
        if(board[index/9][index%9] != '.')
            return solve(board,rows,cols,units,index+1);
        
        int r=index/9;
        int c = index%9;
        
        for(int i=1;i<=9;++i){
            char ch = (char)('0'+i);
            if(isSafe(rows,cols,units,r,c,ch)){
                rows[r].add(ch);
                cols[c].add(ch);
                units[getIndex(r,c)].add(ch);
                board[r][c]=ch;
                if(!solve(board,rows,cols,units,index+1)){
                    rows[r].remove(ch);
                    cols[c].remove(ch);
                    units[getIndex(r,c)].remove(ch);
                    board[r][c]='.';
                }else{
                    return true;
                }
                
            }
        }
        return false;
    }
    
    public boolean isSafe(HashSet<Character>[] rows,HashSet<Character>[] cols, HashSet<Character>[] units, int r, int c, char ch){
        return !rows[r].contains(ch) && !cols[c].contains(ch) && !units[getIndex(r,c)].contains(ch);
    }
    
    
    public int getIndex(int row,int col){
        return (row/3)*3+col/3;
    }
    
    public void init(HashSet<Character>[] set){
        for(int i=0;i<9;++i)
            set[i]=new HashSet<>();
    }
}

// T -> O(9^(nxn))
// S -> O(9x(9^3))