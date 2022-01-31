//DFS using call stack

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        
        for (int i = 0;i < edges.length;i++) {
            addEdge(adjList, edges[i][0], edges[i][1]);
            addEdge(adjList, edges[i][1], edges[i][0]);
        }
        
        return dfs(adjList, source, destination, new HashSet<Integer>());
    }
    
    
    public static boolean dfs(Map<Integer, List<Integer>> adjList, int current, int target, Set<Integer> seenBefore) {
        if (current == target) {
            return true;
        } 
        for(int child : adjList.get(current)) {
            if (seenBefore.contains(child)) {
                continue;
            }
            System.out.println("Push: " + child);
            
            seenBefore.add(child);
            if (dfs(adjList, child, target, seenBefore)) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void addEdge(Map<Integer, List<Integer>> adjList, int firstNode, int secondNode) {
        List<Integer> list = adjList.getOrDefault(firstNode, new ArrayList<>());
        list.add(secondNode);
        adjList.put(firstNode, list);
    }
}



// DFS using stack
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        
        for (int i = 0;i < edges.length;i++) {
            addEdge(adjList, edges[i][0], edges[i][1]);
            addEdge(adjList, edges[i][1], edges[i][0]);
        }
        
        return dfs(adjList, source, destination, new HashSet<Integer>());
    }
    
    
    public static boolean dfs(Map<Integer, List<Integer>> adjList, int current, int target, Set<Integer> seenBefore) {
        if (current == target) {
            return true;
        } 
        for(int child : adjList.get(current)) {
            if (seenBefore.contains(child)) {
                continue;
            }
            System.out.println("Push: " + child);
            
            seenBefore.add(child);
            if (dfs(adjList, child, target, seenBefore)) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void addEdge(Map<Integer, List<Integer>> adjList, int firstNode, int secondNode) {
        List<Integer> list = adjList.getOrDefault(firstNode, new ArrayList<>());
        list.add(secondNode);
        adjList.put(firstNode, list);
    }
}


// BFS
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        
        for (int i = 0;i < edges.length;i++) {
            addEdge(adjList, edges[i][0], edges[i][1]);
            addEdge(adjList, edges[i][1], edges[i][0]);
        }
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        
        queue.offer(source);
        Set<Integer> seenBefore = new HashSet<>();
        seenBefore.add(source);
        
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            if (currentNode == destination) {
                return true;
            }
            
            for(int child : adjList.get(currentNode)) {
                if (seenBefore.contains(child)) {
                    continue;
                }
                queue.offer(child);
                seenBefore.add(child);
            }
        }
        
        
        return false;
    }
    
    public static void addEdge(Map<Integer, List<Integer>> adjList, int firstNode, int secondNode) {
        List<Integer> list = adjList.getOrDefault(firstNode, new ArrayList<>());
        list.add(secondNode);
        adjList.put(firstNode, list);
    }
}

// Union Find
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        int[] weight = new int[n];
        int[] unionFind = new int[n];
        
        for (int i = 0;i < unionFind.length;i++) {
            unionFind[i] = i;
            weight[i] = 1;
        }
        
        for (int i = 0;i < edges.length;i++) {
            connect(unionFind, weight, edges[i][0], edges[i][1]);
        }
        
        return find(unionFind, source) == find(unionFind, destination);
    }
    
    public static int find(int[] unionFind, int target) {
        int root = target;
        while (unionFind[root] != root) {
            root = unionFind[root];
            
        }
        return root;
    }
    
    public static void connect(int[] unionFind, int[] weight, int nodeOne, int nodeTwo) {
        
        int nodeOneRoot = find(unionFind, nodeOne);
        int nodeTwoRoot = find(unionFind, nodeTwo);
        
        if (nodeOneRoot == nodeTwoRoot) {
            return;
        }
        
        if (weight[nodeOneRoot] < weight[nodeTwoRoot]) {
            unionFind[nodeOneRoot] = nodeTwoRoot;
            weight[nodeTwoRoot] += weight[nodeOneRoot]; 
        } else {
            unionFind[nodeTwoRoot] = nodeOneRoot;
            weight[nodeOneRoot] += weight[nodeTwoRoot];
        }
    }
}

