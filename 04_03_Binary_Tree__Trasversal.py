# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return
        lst = []
        queue = collections.deque()
        queue.append(root)
        while queue:
            #size
            n = len(queue)
            
            # create a new sub list for each level
            sublst = []
            
            for _ in range(n):
                
                q = queue.popleft()
                
                sublst.append(q.val)
                if q.left:
                    queue.append(q.left)
                if q.right:
                    queue.append(q.right)
                    
            lst.append(sublst)
            
        return lst
                    
