class MyStack {
    
    Queue<Integer> q1;
    public MyStack() {
        q1 = new LinkedList<>();
    }
    
    public void push(int x) {
        reverse();
        pushUtil(x);
    }
    
    public void reverse() {
        if(q1.isEmpty()) return;
        int num = q1.poll();
        reverse();
        q1.add(num);
        
    }
    
    public void pushUtil(int x) {
        if(q1.isEmpty()) {
            q1.add(x);
            return;
        }
        int num = q1.poll();
        pushUtil(x);
        q1.add(num);
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
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