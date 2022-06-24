import java.util.* ;
import java.io.*; 
public class Solution {
    public static void setZeros(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        
        for(int i=0;i<c;++i){
           if(matrix[0][i]==0)
               firstRow=true;
        }
        
        for(int i=0;i<r;++i)
            if(matrix[i][0]==0)
                firstCol=true;
        for(int i=1;i<r;++i){
            for(int j=1;j<c;++j) {
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<r;++i){
            for(int j=1;j<c;++j) {
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        
        
            for(int i=0;i<r;++i)
                if(firstCol)
                matrix[i][0]=0;
            for(int i=0;i<c;++i)
                if(firstRow)
                matrix[0][i]=0;
        
    }
}

// T.C. -> O(2(N*M)) ~> O(N2)
// S.C. -> O(1)