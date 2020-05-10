// https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1394/

class Solution {
    /*
        n: str len
        time: O(n)
        space: O(n)
    */
    public int evalRPN(String[] tokens) {
        if(tokens == null) return 0;
        
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens) {
            if(!isOperand(token)) stack.push(Integer.valueOf(token));
            else stack.push(eval(token, stack.pop(), stack.pop()));
        }
        
        return stack.pop();
    }
    
    private boolean isOperand(String s) {
        return s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*");
    }
    
    private int eval(String operand, int op2, int op1) {
        switch(operand) {
            case "+": return op1 + op2;
            case "-": return op1 - op2;
            case "*": return op1 * op2;
            case "/": return op1 / op2;
        }
        
        return -1;
    }
}
