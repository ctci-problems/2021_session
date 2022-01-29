class MyQueue:

    def __init__(self):
        self.firstStack = [ ]
        self.secondStack = [ ]

    def push(self, x) -> None:
        while self.firstStack:
            self.secondStack.append(self.firstStack.pop())
        self.firstStack.append(x)
        while self.secondStack:
            self.firstStack.append(self.secondStack.pop())
    def pop(self):
        return self.firstStack.pop()
        

    def peek(self):
        return self.firstStack[-1]
        
    def empty(self):
        return not self.firstStack
        
