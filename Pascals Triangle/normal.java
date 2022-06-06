import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int numRows) {
                 // Write your code here.
       ArrayList<ArrayList<Long>> l = new ArrayList<>();
        ArrayList<Long> newL;

        for(int i=1;i<=numRows;++i){
            newL = new ArrayList<>();
            Long num = (long)i-1;
            long n = i-1;
            long d = 1;
            newL.add(1l);
            for(int j=2;j<=i;++j){
                newL.add(num);
                n--;
                d++;
                num*=n;
                num/=d;

            }
            l.add(newL);
        }
        return l;
        
	}
}
