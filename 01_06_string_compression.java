class Solution {
    public int compress(char[] chars) {
        int p = 0;
        
        char currentChar = chars[0];
        int currentCount = 1;
        
        for(int i = 1;i <= chars.length;i++) {
            if (i < chars.length && currentChar == chars[i]) {
                currentCount++;
            } else {
                chars[p] = currentChar;
                p++;
                
                char[] numberAsChars = String.valueOf(currentCount).toCharArray();
                
                
                if (currentCount != 1) {
                    for (char digit : numberAsChars) {
                        chars[p] = digit;
                        p++;
                    }
                }
                
                if (i < chars.length) {
                    currentChar = chars[i];
                }
                
                currentCount = 1;
            }
        }
        
        
        return p;
    }
}
