// Solution 1

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> available = new HashMap<>();
        
        
        for (int num : nums) {
            available.put(num, available.getOrDefault(num, 0) + 1);
        }
        System.out.println(available);
        
        List<List<Integer>> reVal = new ArrayList<>();
        
        List<Integer> currentPerm = new ArrayList<>();
        
        permuteHelper(nums, available, currentPerm, reVal);
        
        return reVal;
    }
    
    void permuteHelper(int[] nums, Map<Integer, Integer> available, List<Integer> currentPerm, List<List<Integer>> reVal) {
        if (currentPerm.size() == nums.length) {
            reVal.add(new ArrayList<>(currentPerm));
            return;
        }
        
        for (int num : available.keySet()) {
            if (available.get(num) > 0) {
                available.put(num, available.get(num) - 1);
                currentPerm.add(num);
                permuteHelper(nums, available, currentPerm, reVal);
                currentPerm.remove(currentPerm.size() - 1);
                available.put(num, available.get(num) + 1);
            }
        }
    }
}

// Solution 2
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> hashSet = new HashSet<>();
        
        permuteUniqueHelper(nums, 0, hashSet);
        return new ArrayList<>(hashSet);
    }
    
    void permuteUniqueHelper(int[] nums, int pointer, HashSet<List<Integer>> hashSet) {
        
        hashSet.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        for (int i = pointer;i < nums.length;i++) {
            int temp = nums[pointer];
            nums[pointer] = nums[i];
            nums[i] = temp;
            permuteUniqueHelper(nums, pointer + 1, hashSet);
            nums[i] = nums[pointer];
            nums[pointer] = temp;
        }
    }
}
