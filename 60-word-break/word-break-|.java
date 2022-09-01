
class Solution {
    class Pair {
        int index;
        String word;
        public Pair(int i, String s){
            index=i;
            word=s;
        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        ArrayList<Pair>[] words = new ArrayList[26];

        int dn = wordDict.size();
        boolean[][] dp = new boolean[n][dn];
        for(int i=0;i<dn;++i){
            String word = wordDict.get(i);
            int index = word.charAt(0)-'a';
            if(words[index]==null) words[index]=new ArrayList<>();
            words[index].add(new Pair(i,word));
              
        }
        return solve(s,words,0,dp);
        
    }
    
    public boolean solve(String s, ArrayList<Pair>[] words, int index, boolean[][] dp){
        if(index>=s.length()) return true;
        
        ArrayList<Pair> possibleWords = words[s.charAt(index)-'a'];
        if(possibleWords==null)return false;
        for(int i=0;i<possibleWords.size();++i){
            Pair pair = possibleWords.get(i);
            if(dp[index][pair.index])continue;
            if(pair.word.length()<(s.length()-index+1)){
                boolean flag=true;
                for(int j=0;j<pair.word.length();++j){
                    if(s.charAt(index+j) != pair.word.charAt(j)){
                        dp[index][pair.index]=true;
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    if(solve(s,words,index+pair.word.length(),dp)){
                        return true;
                    }else{
                        dp[index][pair.index]=true;
                    }
                }
                
            }
        }
        return false;
        
    }
}
// O(2^N)worst case
// O(N2)