// https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1388/

class Solution {
    /*
        r, c: rows and cols for matrix
        time: O(r c)
        space: O(r c)
    */
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
        
        int[][] dist = new int[matrix.length][matrix[0].length];
        for(int[] item: dist) Arrays.fill(item, Integer.MAX_VALUE);
        
        Queue<int[]> queue = populateQueue(matrix, dist);
        int[][] dirs = { {1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while(!queue.isEmpty()) {
            int[] coord = queue.remove();
            int r=coord[0], c=coord[1];
            
            for(int[] dir: dirs) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];
                
                if(nextR < 0 || nextR >= matrix.length || 
                   nextC < 0 || nextC >= matrix[0].length ) continue;
                
                if( dist[nextR][nextC] > dist[r][c] + 1) {
                    dist[nextR][nextC] = dist[r][c] + 1;
                    queue.add(new int[] {nextR, nextC});
                }
            }
        }
        
        return dist;
    }
    
    private Queue<int[]> populateQueue(int[][] matrix, int[][] dist) {
        Queue<int[]> queue = new LinkedList<>();
        for(int r=0; r<matrix.length; r++) {
            for(int c=0; c<matrix[0].length; c++) {
                if(matrix[r][c] == 0) {
                    queue.add(new int[] {r, c});
                    dist[r][c] = 0;
                }
            }
        }
        
        return queue;
    }
}
