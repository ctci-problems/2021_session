// Using two queues

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        Deque<TreeNode> queue1 = new ArrayDeque<>();
        Deque<TreeNode> queue2 = new ArrayDeque<>();
        List<List<Integer>> reVal = new ArrayList<>();
        
        queue1.offer(root);
        
        
        while(!queue1.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            
            while(!queue1.isEmpty()) {
                TreeNode node = queue1.poll();
                if (node.left != null) {
                    queue2.offer(node.left);
                }
                if (node.right != null) {
                    queue2.offer(node.right);
                }
                
                row.add(node.val);
            }
            reVal.add(row);
            
            Deque<TreeNode> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }
        
        
        return reVal;
    }
}

// Using count for the row
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> reVal = new ArrayList<>();
        
        queue.offer(root);
        
        
        while(!queue.isEmpty()) {
            int sizeOfQueue = queue.size();
            
            List<Integer> row = new ArrayList<>();
            
            while(sizeOfQueue > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                
                row.add(node.val);
                sizeOfQueue--;
            }
            
            reVal.add(row);
        }
        
        
        return reVal;
    }
}
