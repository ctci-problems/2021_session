class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        self.top = 0
        

    def push(self, x: int) -> None:
        if not self.stack1:
            self.top = x
        self.stack1.append(x)
        print("stack1",self.stack1)
        
        

    def pop(self) -> int:
        if not self.stack2:
            while self.stack1:
                    self.stack2.append(self.stack1.pop())
        print("stack2",self.stack2)
        return self.stack2.pop()
        

    def peek(self) -> int:
        if self.stack2:
            return self.stack2[-1]
        else: return self.top
        

    def empty(self) -> bool:
        return len(self.stack2)==0 and len(self.stack1)==0
