class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr,(a,b)->b.profit-a.profit);
        int njobs=0;
        int lastDeadline=0;
        int profit=0;
        int currMax=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;++i){
            Job job = arr[i];
            boolean lastJob=false;
          if(!map.containsKey(job.deadline)){
              map.put(job.deadline,job.deadline);
              njobs++;
          profit+=job.profit;
              
          }else{
             
             int lowerDeadline = map.get(job.deadline);
             while(lowerDeadline > 0){
                 if(!map.containsKey(lowerDeadline)){
                     map.put(job.deadline,lowerDeadline);
                     map.put(lowerDeadline,lowerDeadline);
                     profit+=job.profit;
                     njobs++;
                     break;
                 }else{
                     lowerDeadline--;
                     if(map.containsKey(lowerDeadline)){
                         lowerDeadline=map.get(lowerDeadline)-1;
                     }
                 }
             }
          }
          
        }
        return new int[]{njobs,profit};
    }
}

// T-> O(NLogN) + O(N*M)(worst case)
// S-> O(N)