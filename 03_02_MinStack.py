class MinStack:
    """
    MinStack implementation
    This solution uses two stacks, one holding the items on stack and the 
    other storing the current minimum 
    ie. stack = [5, 3, 4, 2, 3, 4, 1]
        mins =  [5, 3, 3, 2, 2, 2, 1]
        Push -> we append to the stack and also check with the top of the min stack
        for the current min which is stored in the mins stack
        Pop -> We pop from both the stack and mins
        getMin -> We retrieve the top element on the min stack
    """

    def __init__(self):
        self.stack = []
        self.mins = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if len(self.mins) == 0:
            self.mins.append(val)
            return
        self.mins.append(min(self.mins[-1], val))
        
        
    def pop(self) -> None:
        self.mins.pop()
        return self.stack.pop()
        

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.mins[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
