class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        class Platform {
            int arr;
            int dep;
            Platform(int arrival,int departure){
                this.arr=arrival;
                this.dep = departure;
            }
        }
        
        Platform[] platforms = new Platform[n];
        for(int i=0;i<n;++i){
            platforms[i]=new Platform(arr[i],dep[i]);
        }
        Arrays.sort(platforms,(a,b)->a.arr-b.arr);
        List<Integer> deps = new ArrayList<>();
        int ans=0;
        for(int i=0;i<n;++i){
            boolean willWait=true;
            for(int j=0;j<deps.size();++j){
                if(platforms[i].arr>deps.get(j)){
                    deps.set(j,platforms[i].dep);
                    willWait=false;
                    break;
                }
            }
            if(willWait){
                deps.add(platforms[i].dep);
                ans++;
            }
        }
        return deps.size();
    }
    
}

// T -> O(2NLogN)+O(N2)
// S -> O(1)