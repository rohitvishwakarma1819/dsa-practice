class Solution {
    public int reversePairs(int[] nums) {
        int[] arr = new int[nums.length];
        return mergeSort(nums,arr,0,nums.length-1);
    }
    
    public int mergeSort(int[] arr,int[] marr, int l, int h){
        if(l<h){
            int pairs=0;
            int m = (l+h)/2;
            pairs+=mergeSort(arr,marr,l,m);
            pairs+=mergeSort(arr,marr,m+1,h);
            pairs+=merge(arr,marr,l,m+1,h);
            return pairs;
        }
        return 0;
    }
    
    public int merge(int[] arr,int[] marr, int l, int m, int h){
        int i=l;
        int j=m;
        int k=l;
        int pairs=0;
        int j2=m;
        while(i<m && j<=h){
            while(j2<=h && arr[i]>(2*((long)arr[j2]))){
                pairs+=m-i;
                j2++;
            }
            if(arr[i]<=arr[j]){
                marr[k++]=arr[i++];
            }else{
                // if(arr[i]>(2*arr[j])){
                //     pairs+=m-i;
                // }
                marr[k++]=arr[j++];
            }
        }
        while(i<m){
            while(j2<=h && arr[i]>(2*((long)arr[j2]))){
                pairs+=m-i;
                j2++;
            }
            marr[k++]=arr[i++];
        }
        while(j<=h){
            marr[k++]=arr[j++];
        }
        for( i=l;i<=h;++i){
            arr[i]=marr[i];
        }
        return pairs;
    }
}

// T -> O(N*LogN) + O(N) + O(N)
//     Mergesort    Merge   Counting
// S -> O(N) + O(stackFrame.size())
//     Extra array