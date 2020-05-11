// https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1393/

class Solution {
    /*
        r, c: row and col of matrix
        time: O(r c)
        space: O(r c)
    */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[0].length == 0 )  return image;
        int origColor = image[sr][sc];
        if(origColor == newColor) return image;
        
        return floodFill(image, sr, sc, newColor, origColor);
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor, int origColor) {
        if(sr < 0 || sr >= image.length ||
           sc < 0 || sc >= image[0].length )  return image;
        
        if(image[sr][sc] != origColor) return image;
        
        image[sr][sc] = newColor;
        floodFill(image, sr+1, sc, newColor, origColor);
        floodFill(image, sr-1, sc, newColor, origColor);
        floodFill(image, sr, sc+1, newColor, origColor);
        floodFill(image, sr, sc-1, newColor, origColor);
        
        return image;
    }
    
}
