// https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1371/

class Solution {
    public int numSquares(int n) {
        List<Integer> squares = prepSquaresUpTo(n);
        
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int depth= 0;
        
        while(!set.isEmpty()) {
            depth++;
            Set<Integer> nextSet = new HashSet<>();
            
            for(int remainder: set) {
                for(int square: squares) {
                    if(remainder == square) return depth;
                    
                    if(remainder < square) break;
                    
                    nextSet.add(remainder-square);
                }
            }
            
            set = nextSet;
        }
        
        return depth;
    }
    
    private List<Integer> prepSquaresUpTo(int n) {
        List<Integer> squares = new ArrayList<>();
        for(int i=1; i*i <= n; i++)
            squares.add(i*i);
        
        return squares;
    }
}
