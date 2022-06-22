import java.util.* ;
import java.io.*; 
public class Solution {
    public static void setZeros(int matrix[][]) {
        // Write your code here..
         int r = matrix.length;
        int c = matrix[0].length;
        int[] row = new int[r];
        int[] col = new int[c];
        
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j) {
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j) {
                if(row[i]==1 || col[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }

}

// T.C. -> O(2(N*M)) ~> O(N2)
// S.C. -> O(N+M) ~> O(N)