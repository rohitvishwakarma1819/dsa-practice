
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1)
            return s.length();
        int maxLength = 0;
        int length=0;
        int start =0;
        int[] htable = new int[127];
        Arrays.fill(htable,-1);
        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            int ascii = c;
            if(htable[ascii]==-1){
                htable[ascii]=i;
                length = (i-start)+1;
            }else{
                start = Math.max(start,htable[ascii]+1);
                length = i-start+1;
                htable[ascii]=i;
            }
            maxLength = Math.max(length,maxLength);
        }
        return maxLength;
    }
}

// T -> O(N)
// S -> O(N)