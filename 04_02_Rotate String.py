class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        if len(s)!=len(goal): return False
        
        #linear solution O(n)      
        return goal in (s+s) 
        
        
        '''
        0(n**2)
        for i in range(len(goal)):
            if s == goal: return True 
                s = s[-1] + s[:-1]
        return False
        '''
