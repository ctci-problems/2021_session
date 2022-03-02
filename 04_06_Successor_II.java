class Solution {
    public Node inorderSuccessor(Node node) {
        int inputVal = node.val;
        
        if (node.right == null) {
            while (node.parent != null) {
                if (node.parent.val > inputVal) {
                    return node.parent;
                }
                node = node.parent;
            }
            
            return node.parent;
        }
        
        Node smallestNodeOnRight = node.right;
        
        while (smallestNodeOnRight.left != null) {
            smallestNodeOnRight = smallestNodeOnRight.left;
        }
        
        
        return smallestNodeOnRight;
    }
}

class Solution {
    public Node inorderSuccessor(Node node) {
        if (node.right != null) {
            Node successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        } else if (node.parent != null) {
            Node successor = node.parent;
            while (successor.parent != null && successor.val <= node.val) {
                successor = successor.parent;
            }
            if (successor.val > node.val) {
                return successor;
            }
            return null;
        } else {
            return null;
        }
    }
}
