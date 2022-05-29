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
