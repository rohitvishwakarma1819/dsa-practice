class Solution {
    public List<List<String>> partition(String s) {
        
        int n=s.length();
        List<List<String>> ans = new LinkedList<>();
        List<String> currList = new ArrayList<>();
         partitionUtil(s,ans,currList,0);
        return ans;
        
    }
    
    public void partitionUtil(String s,List<List<String>>ans,List<String> currList, int ci){

        if(ci>=s.length()){
                ans.add(new ArrayList<>(currList));
            }
        for(int i=ci;i<s.length();++i){
             if(isPalindrome(s,ci,i)){
                currList.add(s.substring(ci,i+1));
                partitionUtil(s,ans,currList,i+1);
               currList.remove(currList.size()-1);
            }
        }
        
        
    }
    public boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
    
}
// T-> O(N*2^N)
// S-> O(N*N)