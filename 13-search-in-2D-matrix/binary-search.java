class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int l=0;
        int h = r*c-1;
        
        while(l<=h){
            int mid = (l+h)/2;
            int i=mid/c;
            int j = mid%c;
            int num = matrix[i][j];
            if(num == target){
                return true;
            }
            if(num<target){
                l = mid+1;
            }else{
                h=mid-1;
            }
        }
        return false;
        
    }
}