// https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1387/

class MyStack {
    Queue<Integer> enQueue;
    Queue<Integer> deQueue;
    int top;

    /** Initialize your data structure here. */
    public MyStack() {
        enQueue = new LinkedList<>();
        deQueue = new LinkedList<>();
        top = -1;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        enQueue.add(x);
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int ret = -1;
        top = -1;
        while(enQueue.size() > 1) {
            top = enQueue.remove();
            deQueue.add(top);
        }
        if(enQueue.size() == 1) ret = enQueue.remove();
        while(!deQueue.isEmpty()) enQueue.add(deQueue.remove());

        return ret;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return enQueue.isEmpty() && deQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
