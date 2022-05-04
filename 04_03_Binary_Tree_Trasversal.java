

// Count row
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> reVal = new ArrayList<>();
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            
            int current = queue.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0;i < current;i++) {
                TreeNode currentNode = queue.poll();
                row.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                } 
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            reVal.add(row);
        }
        
        System.out.println(reVal);
        
        return reVal;
    }
}


// Two list
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> reVal = new ArrayList<>();
        
        List<TreeNode> primaryList = new ArrayList<>();
        List<TreeNode> secondaryList = new ArrayList<>();
        
        
        primaryList.add(root);
        
        
        
        while(!primaryList.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            secondaryList = new ArrayList<>();
            
            for(TreeNode currentNode : primaryList) {
                row.add(currentNode.val);
                if (currentNode.left != null) {
                    secondaryList.add(currentNode.left);
                } 
                if (currentNode.right != null) {
                    secondaryList.add(currentNode.right);
                }
            }
            
            primaryList = secondaryList;
            reVal.add(row);
        }
        return reVal;
    }
}
