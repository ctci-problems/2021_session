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


class Solution {
    public int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
      
        int count = 1;
        int outputIndex = 0;
        
        
        for (int i = 1;i <= chars.length;i++) {
            
            if (i != 0 && i != chars.length && chars[i] == chars[i - 1]) {
                count++;
            } else {
                chars[outputIndex] = chars[i - 1];
                outputIndex++;
                
                if (count > 1) {
                    String digitsAsString = count + "";
                    
                    for (char digit : digitsAsString.toCharArray()) {
                        chars[outputIndex] = digit;
                        outputIndex++;
                    }
                }
                
                
                count = 1;
            }
        }
        
        return outputIndex;
    }
}


