import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        return mergeSort(arr,0,n-1);
        
    }
    public static long mergeSort(long[] arr, int l, int h){
        if(l<h){
            long inv=0;
            int mid = (l+h)/2;
            inv+=mergeSort(arr,l,mid);
            inv+=mergeSort(arr,mid+1,h);
            inv+=merge(arr,l,mid+1,h);
            return inv;
        }
        return 0;
    }
    
    public static long merge(long[] arr, int l,int m, int h) {
        long inv=0;
        int l1=l;
        int l2=m;
        long[] temp = new long[h-l+1];
        int ti=0;
        while(l1<m && l2<=h){
            if(arr[l1]<=arr[l2])
            { 
               temp[ti++]=arr[l1++];      
            }
            else{
                inv+=m-l1;
                temp[ti++]=arr[l2++];
            }
        }
        
        while(l1<m){
            temp[ti++]=arr[l1++];
        }
        while(l2<=h)
            temp[ti++]=arr[l2++];
        
        for(int i=0;i<ti;++i){
            arr[i+l]=temp[i];
        }
        return inv;
    }
}