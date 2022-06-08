// A
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<(n/2);++i){
            for(int j=i;j<(n-1-i);++j){
                rotate(matrix[i][j],0,i,j,matrix);
            }
        }
    }
    
    public void rotate(int num, int count, int r,int c, int[][]matrix){
        int oldVal = matrix[r][c];
        matrix[r][c] = num;
        int newR = c;
        int newC = matrix.length-1-r;
        if(count < 4)
        rotate(oldVal,count+1,newR,newC,matrix);
    }
}

// T -> O(N*N)
// S -> O(1)