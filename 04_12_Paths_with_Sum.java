class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        
        prefixSum.put(0, 1);
        
        return pathSumHelper(root, prefixSum, 0, targetSum);
    }
    
    int pathSumHelper(TreeNode current, Map<Integer, Integer> prefixSum, int currentSum, int targetSum) {
        if (current == null) {
            return 0;
        }
        
        currentSum += current.val;
        
        
        
        int targetSumCount = prefixSum.getOrDefault(currentSum - targetSum, 0);
        
        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);
        
        
        targetSumCount += pathSumHelper(current.left, prefixSum, currentSum, targetSum);
        targetSumCount += pathSumHelper(current.right, prefixSum, currentSum, targetSum);
        
        prefixSum.put(currentSum, prefixSum.get(currentSum) - 1);
        
        return targetSumCount;
        
    }
}
