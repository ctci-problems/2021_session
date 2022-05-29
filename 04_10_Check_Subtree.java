class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (isSubtreeHelper(root, subRoot)) {
            return true;
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }
    
    boolean isSubtreeHelper(TreeNode current, TreeNode currentSubRoot) {
        if (current == null && currentSubRoot == null) {
            return true;
        }
        if (current == null || currentSubRoot == null) {
            return false;
        }
        
        if (current.val == currentSubRoot.val) {
            return isSubtreeHelper(current.left, currentSubRoot.left)
                && isSubtreeHelper(current.right, currentSubRoot.right);
        } else {
            return false;
        }
    }
}
