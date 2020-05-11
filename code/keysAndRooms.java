// https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1391/

class Solution {
    /*
        r: num of rooms
        k: num of keys
        time: O(r + k)
        space: O(r) ?
    */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] openedArr = new boolean[rooms.size()];
        openedArr[0] = true;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(rooms.get(0));
        
        while(!queue.isEmpty()) {
            Integer key= queue.remove();
            if(openedArr[key]) continue;
            
            openedArr[key] = true;
            
            List<Integer> newKeys = rooms.get(key);
            for(int newKey: newKeys) {
                if(openedArr[newKey]) continue;
                queue.add(newKey);
            }
        }
        
        return canVisitAll(openedArr);
    }
    
    private boolean canVisitAll(boolean[] openedArr) {
        for(boolean opened: openedArr) {
            if(!opened) return false;
        }
        
        return true;
    }
}
