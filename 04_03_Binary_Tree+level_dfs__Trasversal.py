# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        levels = defaultdict(list)

        def listt(node, level):
            if not node: return
            levels[level].append(node.val)
            listt(node.left, level+1)
            listt(node.right, level+1)

        listt(root,0)
        print(levels)
        return [levels[i] for i in range(len(levels))]
