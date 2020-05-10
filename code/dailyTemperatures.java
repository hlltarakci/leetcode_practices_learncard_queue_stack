// https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1363/

class Solution {
    /*
        n: arr len
        time: O(n)
        space: O(n) ?
    */
    public int[] dailyTemperatures(int[] T) {
        if(T == null) return null;
        
        int[] diffs = new int[T.length];
        
        Stack<Integer> stack = new Stack<>();
        for(int i=T.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
            diffs[i] = stack.isEmpty() ? 0 : stack.peek()-i;
            stack.push(i);
        }
        
        return diffs;
    }
}
