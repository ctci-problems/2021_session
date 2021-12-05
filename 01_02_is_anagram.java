class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        
        if (s.length() != t.length()) {
            return false;
        }
        
        for (int i = 0;i < sCharArray.length;i++) {
            if (sCharArray[i] != tCharArray[i]) {
                return false;
            }
        }
        
        return true;
    }
}
