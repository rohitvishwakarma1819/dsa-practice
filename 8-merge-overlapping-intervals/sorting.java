class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        int replaceIndex=0;
        int l=intervals[0][0];
        int h=intervals[0][1];
        
        for(int i=1;i<intervals.length;++i){
            int cl=intervals[i][0];
            int ch=intervals[i][1];
            
            if(cl<=h){
                h=Math.max(h,ch);
            }else{
                intervals[replaceIndex][0]=l;
                intervals[replaceIndex][1]=h;
                l=cl;
                h=ch;
                replaceIndex++;
            }
        }
        intervals[replaceIndex][0]=l;
        intervals[replaceIndex][1]=h;
        
        int[][] result = new int[replaceIndex+1][2];
        for(int i=0;i<=replaceIndex;++i){
            result[i][0]=intervals[i][0];
            result[i][1]=intervals[i][1];
        }
        return result;
    }
}

// T -> O(NLogN) + O(N) ~> O(NLogN)
// S -> worst O(N)