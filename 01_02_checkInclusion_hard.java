class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        
        for (char letter : s1.toCharArray()) {
            freq[letter - 'a']++;
        }
        
        
        
        
        int nonZeroCount = 0;
        for (int i = 0;i < freq.length;i++) {
            if (freq[i] != 0) {
                nonZeroCount++;
            }
        }
        
        for (int i = 0;i < s2.length();i++) {
            // int[] copyFreq = Arrays.copyOf(freq, freq.length);
            freq[s2.charAt(i) - 'a']--;
            
            if (freq[s2.charAt(i) - 'a'] == 0) {
                nonZeroCount--;
            }
            
            if (freq[s2.charAt(i) - 'a'] == -1) {
                nonZeroCount++;
            }
            
            
            if (i - s1.length() >= 0) {
                freq[s2.charAt(i - s1.length()) - 'a']++;
                if (freq[s2.charAt(i - s1.length()) - 'a'] == 0) {
                    nonZeroCount--;
                }
                
                if (freq[s2.charAt(i - s1.length()) - 'a'] == 1) {
                    nonZeroCount++;
                }
            }
            
            if (nonZeroCount == 0) {
                return true;
            }
            
        }
        
        return false;
    }
}


// s1 = "ab", s2 = "eidbaooo"
//              "a b"
//  "e i d b a o o o"
//   0 1 2 3 4 5 6 7 

//  i
//  j




// s1 = "ab", s2 = "eidboaoo"

// s1 = "ab", s2 = "abdeiooo"
