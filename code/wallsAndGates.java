// https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1373/

class Solution {
    /*
        r, c : rows, cols of matrix
        time: O(r c)
        space: O(r c)
    */
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        
        Queue<int[]> queue = populateQueue(rooms);
        
        while(!queue.isEmpty()) {
            int[] coord = queue.remove();
            int r = coord[0], c = coord[1];
            
            int newVal = rooms[r][c] + 1;
            // up
            process(queue, rooms, r-1, c, newVal);
            
            // down
            process(queue, rooms, r+1, c, newVal);
            
            // left
            process(queue, rooms, r, c-1, newVal);
            
            // right
            process(queue, rooms, r, c+1, newVal);
        }
        
        
    }
    
    private void process(Queue<int[]> queue, int[][] rooms, int r, int c, int newVal) {
        if(r < 0 || r >= rooms.length || c < 0 || c >= rooms[0].length || 
          rooms[r][c] != Integer.MAX_VALUE) return;
        
        rooms[r][c] = newVal;
        queue.add(new int[] {r, c});
    }
    
    private Queue populateQueue(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        
        for(int r=0; r<rooms.length; r++) {
            for(int c=0; c<rooms[0].length; c++) {
                if(rooms[r][c] == 0) queue.add(new int[] {r, c});
            }
        }
        
        return queue;
    } 
}
