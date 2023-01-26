class MyStack {
    
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
     q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        while(!q1.isEmpty() && q1.size()!=1){
            q2.add(q1.poll());
        }
        int res = q1.poll();
        while(!q2.isEmpty())
            q1.add(q2.poll());
        return res;
    }
    
    public int top() {
        int x = pop();
        q1.add(x);
        return x;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */