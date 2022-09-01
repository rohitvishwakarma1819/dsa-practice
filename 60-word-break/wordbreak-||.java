class Solution {
       class Pair {
        int index;
        String word;
        public Pair(int i, String s){
            index=i;
            word=s;
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        
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
        List<String> ans = new ArrayList<>();
         solve(s,words,0,dp,ans,new String(""));
        return ans;
        
    }
    
    public void solve(String s, ArrayList<Pair>[] words, int index, boolean[][] dp, List<String>ans, String currentAns){
        if(index>=s.length()){
            ans.add(currentAns);
            return;
        }
        
        ArrayList<Pair> possibleWords = words[s.charAt(index)-'a'];
        if(possibleWords==null)return;
        for(int i=0;i<possibleWords.size();++i){
            Pair pair = possibleWords.get(i);
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
                    int oldlen = currentAns.length();
                    currentAns+=pair.word;
                    if(!(index+pair.word.length()==s.length()))
                        currentAns+=" ";
                    solve(s,words,index+pair.word.length(),dp,ans,currentAns);
                      
                         currentAns = currentAns.substring(0,oldlen);

                    
                }
                
            }
        }
        
    }
}


// T -> 