class MyQueue {
    
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();

    public MyQueue() {
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        moveIfEmpty();
        
        return stack2.pop();
    }
    
    public int peek() {
        moveIfEmpty();
        
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    private void moveIfEmpty() {
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
