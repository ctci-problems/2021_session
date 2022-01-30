class MinStack {
public:
    vector<pair<int,int>> s;
    MinStack() {
        s.clear();
    }

    void push(int val) {
        if (s.size() == 0) s.push_back({val, val});
        // otherwise we push the current min if less than value
        else if (getMin() > val) s.push_back({val, val});
        else s.push_back({val, getMin()});
    }

    void pop() {
        s.pop_back();
    }

    int top() {
        return s[s.size() - 1].first;
    }

    int getMin() {
        return s[s.size() - 1].second;
    }
};
