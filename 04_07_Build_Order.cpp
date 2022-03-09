class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {

        vector<int> indegree(numCourses);
        vector<vector<int>> graph(numCourses);
        vector<int> courseList;
        queue<int> topoSortUtil;

        auto coursesSorted = 0;

        for (auto prereq : prerequisites)
        {
            indegree[prereq[0]]++;
            graph[prereq[1]].push_back(prereq[0]);
        }
        
        for (auto course = 0; course < numCourses; course++)
            if (indegree[course] == 0)
                topoSortUtil.push(course);
        
        while (!topoSortUtil.empty())
        {
            auto course = topoSortUtil.front(); topoSortUtil.pop();            
            
            for (auto next_course : graph[course])
            {
                indegree[next_course]--;
                
                if (indegree[next_course] == 0)
                   topoSortUtil.push(next_course);
            }

            courseList.push_back(course);
            coursesSorted++;
        }

        return (coursesSorted == numCourses) ? courseList : vector<int>();
    }
};
