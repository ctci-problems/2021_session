class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            TreeNode smallestNodeOnRight = p.right;
        
            while (smallestNodeOnRight.left != null) {
                smallestNodeOnRight = smallestNodeOnRight.left;
            }
            return smallestNodeOnRight;
        }
        
        TreeNode current = root;
        TreeNode successor = null;
        
        while (current != p) {
            if (p.val < current.val) {
                successor = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        
        return successor;
    }
}


class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        LinkNode dummyHead = new LinkNode(null);
        dfs(root, dummyHead);
        
        LinkNode current = dummyHead.next;
        while(current != null) {
            if (current.ref == p) {
                if (current.next == null) {
                    return null;
                }
                return current.next.ref;
            }
            current = current.next;
        }
        return null;
    }
    
    LinkNode dfs(TreeNode node, LinkNode listNode) {
        if (node == null) {
            return listNode;
        }
        
        listNode = dfs(node.left, listNode);
        listNode.next = new LinkNode(null);
        listNode.next.ref = node;
        listNode = listNode.next;
        listNode = dfs(node.right, listNode);
        return listNode;
    }
    
    
    class LinkNode {
        TreeNode ref;
        LinkNode next;
        
        LinkNode(TreeNode ref) {
            this.ref = ref;
        }
    }
}
