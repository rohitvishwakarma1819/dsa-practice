import java.util.*;
public class Solution {
	public static String graphColoring(int[][] graph, int m) {
		 // Your code here
        int n = graph.length;
         int[] colors = new int[n];
         return color(graph,m,colors,0,n)?"YES":"NO";
        
    }
    
    public static boolean color(int[][] graph, int m, int[] colors, int index, int n) {
        if(index>=n)
        return true;
        
        for(int color = 1;color<=m;++color){
            if(canColor(graph,colors,index,color,n)){
                colors[index] = color;
                if(color(graph,m,colors,index+1,n)){
                    return true;
                }
                colors[index]=0;
            }
        }
        return false;
    }
    
    public static boolean canColor(int[][] graph, int[] colors, int index,int color, int n){
        for(int i=0;i<n;++i){
            if(graph[i][index]==1 || graph[index][i]==1){
                if(color == colors[i]){
                    return false;
                }
            }
            
        }
        return true;
    }
}


// T -> O(N^M)
// S -> O(N)