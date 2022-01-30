class MyQueue:

    def __init__(self):
        self.firstStack = [ ]
        self.secondStack = [ ]

    def push(self, x) -> None:
        self.firstStack.append(x)
        
    def pop(self):
        self.peek()
        return self.secondStack.pop()   

    def peek(self):
        if not self.secondStack:
            while self.firstStack:
                self.secondStack.append(self.firstStack.pop())
        return self.secondStack[-1]
        
    def empty(self):
        return not self.firstStack and not self.secondStack
    
