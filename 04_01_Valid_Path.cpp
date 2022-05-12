class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {

        vector<vector<int>> graph(n, vector<int>());
        vector<bool> visited(n, false);

        for (auto edge : edges)
        {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }

        queue<int> bfsQueue;
        bfsQueue.push(source);
        
        while(!bfsQueue.empty())
        {
            auto current_node = bfsQueue.front(); 
            bfsQueue.pop();
            
            if (visited[current_node]) 
                continue;

            if (current_node == destination) 
                return true;
                
            visited[current_node] = true;

            for (auto connection : graph[current_node])
                bfsQueue.push(connection);
        }

        return false;
    }
};
