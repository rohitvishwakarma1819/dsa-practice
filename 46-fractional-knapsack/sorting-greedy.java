class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        Arrays.sort(arr,(a,b)->{
            double res = ((double)b.value)/b.weight-((double)a.value)/a.weight;
            if(res>0){
                return 1;
            }
            if(res==0)
            return 0;
            return -1;
        });
        double ans=0;
        double dw=W;
        int i=0;
        while(i<n && dw!=0){
            if(dw >= arr[i].weight){
                dw-=arr[i].weight;
                ans+=arr[i].value;
            }else{
                
                ans+= (((double)(arr[i].value))/arr[i].weight)*dw;
                dw=0;
                break;
            }
            i++;
        }
        return ans;
        
    }
}