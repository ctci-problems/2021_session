class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> reVal = new ArrayList<>();
        
        parenHelper(n * 2, 0, new StringBuffer(), reVal);
        
        return reVal;
    }
    
    
    void parenHelper(int slotsLeft, int leftParens, StringBuffer currentValue, List<String> reVal) {
        // Base case also known as stopping case
        if (leftParens < 0) {
            return;
        } else if(slotsLeft == 0 && leftParens == 0) {
            reVal.add(currentValue.toString());
            return;
        } else if (slotsLeft == 0 || leftParens > slotsLeft) {
            return;
        }
        
        
        // Recursive part
        currentValue.append("(");
        parenHelper(slotsLeft - 1, leftParens + 1, currentValue, reVal);
        currentValue.deleteCharAt(currentValue.length() - 1);
        
        currentValue.append(")");
        parenHelper(slotsLeft - 1, leftParens - 1, currentValue, reVal);
        currentValue.deleteCharAt(currentValue.length() - 1);
    }
}
