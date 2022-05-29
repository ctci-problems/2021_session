class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> reVal = new ArrayList<>();
        
        permuteHelper(nums, new ArrayList<>(), reVal);
        
        return reVal;
    }
    
    
    void permuteHelper(int[] nums, List<Integer> currentList, List<List<Integer>> reVal) {
        
        if (currentList.size() == nums.length) {
            reVal.add(new ArrayList(currentList));
        }
        
        for (int i = 0;i < nums.length;i++) {
            if (currentList.contains(nums[i])) {
                continue;
            }
            
            currentList.add(nums[i]);
            permuteHelper(nums, currentList, reVal);
            currentList.remove(currentList.size() - 1);
        }
    }
}
