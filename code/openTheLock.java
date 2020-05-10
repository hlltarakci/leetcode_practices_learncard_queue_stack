// https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1375/

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendsSet = new HashSet<>();
        for(String deadend: deadends) deadendsSet.add(deadend);
        
        if(deadendsSet.contains("0000")) return -1;
        
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        queue.add(null);
        
        Set<String> seenSet = new HashSet<>();
        seenSet.add("0000");
        
        int depth = 0;
        while(!queue.isEmpty()) {
            String curr = queue.remove();
            if(curr == null) {
                depth++;
                if(queue.peek() != null) queue.add(null);
                continue;
            }
            
            if(curr.equals(target)) return depth;
            
            for(int i=0; i<4; i++) {
                // turn left & right
                int[] directions = new int[] {-1, 1};
                for(int direction: directions) {
                    int num = ((curr.charAt(i) - '0') + 10 + direction) % 10; 

                    String newVal = curr.substring(0, i) + num + curr.substring(i+1);
                    if(!deadendsSet.contains(newVal)) {
                        if(!seenSet.contains(newVal)) {
                            seenSet.add(newVal);
                            queue.add(newVal);
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}
