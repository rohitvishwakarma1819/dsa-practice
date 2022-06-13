class Solution {
    public int uniquePaths(int m, int n) {
        int directions = m+n-2;
        int minDirections=m-1;
        double res=1;
        
        for(int i=1;i<=minDirections;++i){
            res = res*(directions-minDirections+i)/(i);
        }
        return (int)res;
        
    }
  
}
// T-> O(m,n)
// S-> O(1) 