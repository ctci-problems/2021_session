// Solution 1

class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minValue;

    public MinStack() {
        stack = new ArrayDeque<>();
        minValue = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        
        if (minValue.isEmpty() || val <= minValue.peek()) {
            minValue.push(val);
        }
    }
    
    public void pop() {
        int val = stack.pop();
        
        if (val == minValue.peek()) {
             minValue.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minValue.peek();
    }
}


// Solution 2

class MinStack {
    Deque<Integer> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
        
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        int minValue = stack.peek();
        
        for (int val : stack) {
            minValue = Math.min(minValue, val);
        }
        return minValue;
    }
}
