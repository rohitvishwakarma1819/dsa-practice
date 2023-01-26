class MedianFinder {
    PriorityQueue<Integer> maxpq = new PriorityQueue<Integer>((a,b)-> b-a);
    PriorityQueue<Integer> minpq = new PriorityQueue<Integer>((a,b)-> a-b);
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
       if(maxpq.isEmpty() || maxpq.peek()>num){
           maxpq.add(num);
       }else{
           minpq.add(num);
       }
        
        
       if(minpq.size()> maxpq.size()){
           maxpq.add(minpq.poll());
       }else if(maxpq.size()>minpq.size()+1){
           minpq.add(maxpq.poll());
       }
           
    }
    
    public double findMedian() {
        if(minpq.size()==0) return maxpq.peek();

        if((maxpq.size()+minpq.size())%2==0){
            return ((double)maxpq.peek()+(double)minpq.peek())/2.0;
        }
        
        return maxpq.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// T -> 
// addNum -> O(NlogN)
// find -> O(1)

// S-> O(N)