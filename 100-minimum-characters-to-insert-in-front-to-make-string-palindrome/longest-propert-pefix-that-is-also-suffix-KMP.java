
public class Solution {

    public static int minCharsforPalindrome(String str) {
        //Write your code here
        StringBuilder sb = new StringBuilder(str);
        String s = str +"$"+ sb.reverse().toString();
        int n = s.length();
        int max = 1;
        int[] lps = new int[n];
        lps[0] = 0;
        int len = 0;
        int i = 1;
        
        while(i < n) {
            if(s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
                
                max = Math.max(max, len);
            }else {
                if(len > 0) {
                    len = lps[len - 1];
                }else {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return Math.max(str.length() - lps[n-1], 0);
    }

}
// O(2N)
// O(2N)