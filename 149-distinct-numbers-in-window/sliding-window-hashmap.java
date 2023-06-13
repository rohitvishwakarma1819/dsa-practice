public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        int n = A.size();
        if (B > n)
            return new ArrayList<Integer>();
        int wn = n - B + 1;
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap();
        int count = 0;
        for (int i = 0; i < B - 1; ++i) {
            int c = map.getOrDefault(A.get(i), 0);
            map.put(A.get(i), c + 1);
            if (c == 0)
                count++;
        }
        int ai = 0;
        for (int i = B - 1; i < n; ++i) {
            int c = map.getOrDefault(A.get(i), 0);
            map.put(A.get(i), c + 1);
            if (c == 0)
                count++;
            res.add(count);
            c = map.get(A.get(i - B + 1));
            map.put(A.get(i - B + 1), c - 1);
            if (c == 1) {
                count--;
                map.remove(A.get(i - B + 1));
            }
        }

        return res;
    }
}

// T -> O(N)
// S -> O(N)