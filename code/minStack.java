// https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1360/

class MinStack {
    Stack<Integer> nums;
    Stack<Integer> mins;

    /** initialize your data structure here. */
    public MinStack() {
        nums = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int x) {
        nums.push(x);
        if(mins.isEmpty() || mins.peek() >= x) mins.push(x);
    }
    
    public void pop() {
        if(mins.peek().equals(nums.peek())) mins.pop();
        nums.pop();
    }
    
    public int top() {
        return nums.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
