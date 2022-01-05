class Solution {
    public boolean isOneEditDistance(String s, String t) {
        
        String shorter;
        String longer;
        if (s.length() > t.length()) {
            longer = s;
            shorter = t;
        } else {
            longer = t;
            shorter = s;
        }
        
        return hasOneDeletion(shorter, longer) || hasOneReplace(shorter, longer);
    }
    
    
    public boolean hasOneDeletion(String shorter, String longer) {
        if (shorter.length() + 1 != longer.length()) {
            return false;
        }
        
        int shorterPointer = 0;
        int longerPointer = 0;
        
        
        while (shorterPointer < shorter.length() && longerPointer < longer.length()) {
            
            if (shorter.charAt(shorterPointer) == longer.charAt(longerPointer)) {
                shorterPointer++;
            }
            longerPointer++;
        }
        
        
        return shorterPointer == longerPointer - 1 || longer.length() - longerPointer == 1;
    }
    
    
    public boolean hasOneReplace(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        boolean hasOneReplace = false;
        for (int i = 0;i < s.length();i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (hasOneReplace) {
                    return false;
                }
                hasOneReplace = true;
            }            
        }
        
        
        return hasOneReplace;
    }
}


//https://www.lintcode.com/problem/640/

public class Solution {
    /**
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {

        int p1 = 0;
        int p2 = 0;

        
        for (int i = 0;i < Math.min(s.length(), t.length());i++) {

            if (s.charAt(i) != t.charAt(i)) {
                System.out.println("Letters on the left");
                System.out.println(s.substring(0,i));
                System.out.println(t.substring(0,i));

                System.out.println("Letters in the middle that don't match");
                System.out.println(s.substring(i,i + 1));
                System.out.println(t.substring(i,i + 1));

                // Changing letter case
                String newStringT = t.substring(0,i) + s.substring(i,i + 1) + t.substring(i+1);
                String newStringS = s.substring(0,i) + s.substring(i,i + 1) + s.substring(i+1);
                System.out.println("Letters now match!!");
                System.out.println(newStringT);
                System.out.println(newStringS);
                if (newStringT.equals(newStringS)) {
                    return true;
                }

                if (s.length() < t.length()) {
                    System.out.println("We are deleting from T");
                    String secondNewStringT = t.substring(0,i) + t.substring(i+1);
                    String secondNewStringS = s.substring(0,i) + s.substring(i,i + 1) + s.substring(i+1);
                    if (secondNewStringT.equals(secondNewStringS)) {
                        return true;
                    }
                }

                if (s.length() > t.length()) {
                    System.out.println("We are deleting from S");
                    String secondNewStringT = t.substring(0,i) + t.substring(i,i + 1) + t.substring(i+1);
                    String secondNewStringS = s.substring(0,i) + s.substring(i+1);

                    if (secondNewStringT.equals(secondNewStringS)) {
                        return true;
                    }
                }



                System.out.println("Letters on the right");
                System.out.println(s.substring(i+1));
                System.out.println(t.substring(i+1));
                System.out.println("=======");
            }
        }
        int minLength = Math.min(s.length(), t.length());
        if (Math.abs(s.length() - t.length()) == 1 && s.substring(0,minLength).equals(t.substring(0,minLength))) {
            return true;
        }


        return false;
    }
}
