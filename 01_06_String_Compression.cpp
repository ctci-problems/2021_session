class Solution {
public:
    int compress(vector<char>& chars) {
        
        auto idx = 0, outputIdx = 0; 
        auto n = chars.size();  
        
        while (idx < n)
        {
            char c = chars[idx];
            int current_count = 0;

            while(idx < n)
            {
                if (c == chars[idx]) 
                    current_count++;
                else 
                    break;
    
                idx++;
            }
            
            chars[outputIdx++] = c;
            if (current_count > 1)
            {
                string count_string = to_string(current_count);
                copy(begin(count_string), end(count_string), begin(chars)+outputIdx);
                outputIdx += count_string.length();
            }
        }
        return outputIdx;
    }
};
