class DinnerPlates {
    public:
    int capacity;
    set<int> availableStacks;
    vector<vector<int>> stacks;
    
    DinnerPlates(int capacity) {
        this->capacity = capacity;
        availableStacks.clear();
        stacks.clear();
    }
    
    void push(int val) {

        if (availableStacks.size() > 0)
        {
            auto minIdx = *availableStacks.begin();
            availableStacks.erase(minIdx);
            
            if (minIdx == stacks.size())
                stacks.push_back(vector<int>());

            auto & current = stacks.at(minIdx);
            current.push_back(val);
            
            if(current.size() < this->capacity)
                availableStacks.insert(minIdx);
        }
        else
        {
            auto current = vector<int>(1, val);
            
            if (current.size() < this->capacity)
                availableStacks.insert(stacks.size());

            stacks.push_back(current);
        }
    }
    
    int pop() {
        if (stacks.size() == 0)
            return -1;
        
        auto * currentStack = &stacks.at(stacks.size() - 1);
        
        while(currentStack->size() == 0)
        {
            stacks.pop_back();
            if(stacks.size() == 0)
                return -1;
            currentStack = &stacks.at(stacks.size() - 1);
        }
    
        availableStacks.insert(stacks.size() - 1);
        auto poppedValue = currentStack->at(currentStack->size() - 1); 
        currentStack->pop_back();

        return poppedValue;      
    }
    
    int popAtStack(int index) {

        if (index >= stacks.size())
            return -1;
        
        auto & current = stacks.at(index);

        if (current.size() == 0)
            return -1;

        availableStacks.insert(index);
        auto poppedValue = current[current.size() - 1]; current.pop_back();

        return poppedValue;
    }
};
