class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = n - 1;
        while(i >= 0) {
            while(i >=0 && s.charAt(i) == ' ') i--;
            StringBuilder temp = new StringBuilder();
            while(i >= 0 && s.charAt(i) != ' ') {
                temp.append(s.charAt(i--));
            }
            if(temp.length() > 0) {
                temp.reverse();
                if(sb.length() > 0)
                    sb.append(" ");
                sb.append(temp);
                
            }
        }
        return sb.toString();
    }
}
// O(N)
// O(N)
