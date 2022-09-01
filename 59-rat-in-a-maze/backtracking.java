import java.util.*;
public class Solution {
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] m, int n) {
        // Write your code here.
         ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(m[0][0]==0 || m[n-1][n-1]==0)return ans;
        int[][] directions = new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][] visited = new boolean[n][n];
        ArrayList<Integer>path = new ArrayList<>();
        for(int i=0;i<n*n;++i)path.add(0);
        path.set(n*n-1,1);
        visited[0][0]=true;
        move(m,directions,0,0,visited,n,path,ans);
        return ans;
    }
    
    public static void move(int[][] m, int[][] dir, int r,int c, boolean[][] visited, int n,ArrayList<Integer>path, ArrayList<ArrayList<Integer>>ans) {
        if(r==n-1 && c==n-1)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        
        int row=r,col=c;
        for(int i=0;i<4;++i){
            row=r+dir[i][0];
            col=c+dir[i][1];
            if(row>=0 && row<n && col>=0 && col<n)
            if(!visited[row][col] && m[row][col]==1){
                path.set(r*n+c,1);
                visited[row][col]=true;
                move(m,dir,row,col,visited,n,path,ans);
                visited[row][col]=false;
                path.set(r*n+c,0);
            }
        }
    }
}

// T-> O(4^(N^2))
// S-> O(N2)