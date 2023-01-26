class Solution {
    public String countAndSay(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr.add(1);
        
        for(int i = 2; i <= n; ++i) {
            int j = 0;
            int count = 0;
            int k = 0;
            while(j < arr.size()) {
                if(count == 0) {
                    count++;
                    j++;
                }else {
                    if(arr.get(j) == arr.get(j - 1)) {
                        count++;
                        j++;
                    }else {
                        if(k < arr2.size())
                            arr2.set(k++, count);
                        else
                            {
                            k++;
                            arr2.add(count);}
                        if(k < arr2.size())
                            arr2.set(k++, arr.get(j - 1));
                        else
                            {k++;
                            arr2.add(arr.get(j - 1));}
                        count = 0;
                    }
                }
            }
            if(k < arr2.size())
                arr2.set(k++, count);
            else
                {k++;
                arr2.add(count);}
            if(k < arr2.size())
                arr2.set(k++, arr.get(j - 1));
            else
                arr2.add(arr.get(j - 1));
            arr = (ArrayList)arr2.clone();
        }
        StringBuilder sb = new StringBuilder();
        for(int i: arr) {
            sb.append(""+i);
        }
        return sb.toString();
    }
}