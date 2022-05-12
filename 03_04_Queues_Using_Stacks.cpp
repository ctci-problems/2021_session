class MyQueue {
public:

    stack<int> s1;
    stack<int> s2;

    void clearStack(stack<int> & s)
    {
         while(!s.empty()) s.pop();     
    }
    
    void moveIfEmpty(void)
    {
        if(s2.empty())
            while(!s1.empty())
            {
                s2.push(s1.top()); s1.pop();
            }
    }

    MyQueue() 
    {
        clearStack(s1);
        clearStack(s2);
    }

    void push(int x) {
       s1.push(x); 
    }
    
    int pop() {        
        moveIfEmpty();
        int returnValue = s2.top(); s2.pop();
        return returnValue;
    }
        int peek() {
        moveIfEmpty();
        return s2.top();     
    }
    
    bool empty() {
        return s1.empty() && s2.empty();
    }
};
