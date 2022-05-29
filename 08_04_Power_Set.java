// Solution 1

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> reVal = new ArrayList<>();
        
        for (int i = 0;i < Math.pow(2, nums.length);i++) {
            int bits = i;
            List<Integer> sublist = new ArrayList<>();
            int atBinaryDigit = 0;
            while (bits > 0) {
                if ((1 & bits) == 1) {
                    sublist.add(nums[atBinaryDigit]);
                }
                atBinaryDigit++;
                bits >>>= 1;
            }
            reVal.add(sublist);
            
        }
        
        return reVal;
    }
}


// Solution 2

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> reVal = new ArrayList<>();
        
        
        subsetsHelper(nums, 0, new ArrayList<>(), reVal);
        
        return reVal;
    }
    
    public void subsetsHelper(int[] nums, int currentIndex, List<Integer> currentSubset, List<List<Integer>> reVal) {
        if (nums.length == currentIndex) {
            reVal.add(new ArrayList<>(currentSubset));
            return;
        }
        
        currentSubset.add(nums[currentIndex]);
        subsetsHelper(nums, currentIndex + 1, currentSubset, reVal);
        currentSubset.remove(currentSubset.size() - 1);
        subsetsHelper(nums, currentIndex + 1, currentSubset, reVal);
        
    }
}
