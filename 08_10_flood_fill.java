// Solution 1


class Pixel {
    int sr;
    int sc;
    
    Pixel(int sr, int sc) {
        this.sr = sr;
        this.sc = sc;
    }
}


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Deque<Pixel> queue = new ArrayDeque<>();
        
        int oldColor = image[sr][sc];
        
        if (oldColor == newColor) {
            return image;
        }
        
        queue.offer(new Pixel(sr, sc));
        
        while(!queue.isEmpty()) {
            Pixel pix = queue.poll();
            
            
            if (pix.sc < 0 || pix.sr < 0 || pix.sr >= image.length || pix.sc >= image[0].length || image[pix.sr][pix.sc] != oldColor) {
                continue;
            }
            
            image[pix.sr][pix.sc] = newColor;
            
            queue.push(new Pixel(pix.sr + 1, pix.sc));
            queue.push(new Pixel(pix.sr - 1, pix.sc));
            queue.push(new Pixel(pix.sr, pix.sc + 1));
            queue.push(new Pixel(pix.sr, pix.sc - 1));
        }
        
        return image;
    }
}

// Solution 2
    
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        floodFillHelper(image, sr, sc, image[sr][sc], newColor);
        
        return image;
    }
    
    
    void floodFillHelper(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor || oldColor == newColor) {
            return;
        }
        
        image[sr][sc] = newColor;
        
        floodFillHelper(image, sr - 1, sc, oldColor, newColor);
        floodFillHelper(image, sr + 1, sc, oldColor, newColor);
        floodFillHelper(image, sr, sc - 1, oldColor, newColor);
        floodFillHelper(image, sr, sc + 1, oldColor, newColor);
    }
}


