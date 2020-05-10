// https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1368/

class MovingAverage {

    Queue<Integer> queue;
    int CAPACITY;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        CAPACITY = size;
    }
    
    public double next(int val) {
        if(queue.size() == CAPACITY) queue.remove();
        queue.add(val);
        return avg();
    }
    
    private double avg() {
        int sum = 0;
        if(queue.size() == 0) return sum;
        
        for(int num: queue) sum += num;
        return (double)sum / (double)queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
