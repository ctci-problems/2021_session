class Solution {
public:

    struct disjointSet
    {
        vector<int> parent;

        disjointSet(int size)
        {
            this->parent = vector<int>(size);
            for(auto i = 0; i < size; i++)
                this->parent[i] = i;
        }

        int findRoot(int index)
        {
            if (this->parent[index] == index)
                return index;

            int result = findRoot(this->parent[index]);

            this->parent[index] = result;
            return result;
        }

        void makeUnion(int component1, int component2)
        {
            int root1 = findRoot(component1);
            int root2 = findRoot(component2);

            if(root1 != root2)
                this->parent[root2] = root1;
        }
    };


    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {

        auto * unionFind = new disjointSet(n);

        for (auto edge : edges)
            unionFind->makeUnion(edge[0], edge[1]);

        auto sourceRoot = unionFind->findRoot(source);
        auto destinationRoot = unionFind->findRoot(destination);

        return sourceRoot == destinationRoot;        
    }
};
