class DinnerPlates {
    
    int maxCapacity;
    
    List<Deque<Integer>> stacks = new ArrayList<>();
    TreeSet<Integer> treeSet = new TreeSet<>();

    public DinnerPlates(int capacity) {
        this.maxCapacity = capacity;
    }
    
    public void push(int val) {
        
        if (!treeSet.isEmpty()) {
            int lowestIndex = treeSet.pollFirst();
            
            if (lowestIndex == stacks.size()) {
                stacks.add(new ArrayDeque<>());
            }
            
            Deque<Integer> nonEmptyStack = stacks.get(lowestIndex);
            nonEmptyStack.push(val);
            if (nonEmptyStack.size() < maxCapacity) {
                treeSet.add(lowestIndex);
            }
            return;
        }
        
        
       
        Deque<Integer> newStack = new ArrayDeque<>();
        newStack.push(val);
        
        if (maxCapacity != 1) {
            treeSet.add(stacks.size());
        }
        
        stacks.add(newStack);
        
    }
    
    public int pop() {
        if (stacks.isEmpty()) {
            return -1;
        } else {
            Deque<Integer> currentStack = stacks.get(stacks.size() - 1);
            
            while (currentStack.isEmpty()) {
                stacks.remove(stacks.size() - 1);
                if (stacks.isEmpty()) {
                    return -1;
                } else {
                    currentStack = stacks.get(stacks.size() - 1);
                }
            }
            treeSet.add(stacks.size() - 1);
            return currentStack.pop();
        }
    }
    
    public int popAtStack(int index) {
        if (index >= stacks.size()) {
            return -1;
        }
        
        Deque<Integer> stack = stacks.get(index);
        
        if (stack.isEmpty()) {
            return -1;
        } else {
            treeSet.add(index);
            return stack.pop();
        }  
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
