// https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1379/

class Solution {
    public String decodeString(String s) {
        if(s == null) return "";
        Stack<String> stack = new Stack<>();
        
        int multiplier = 0;
        StringBuilder temp = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(Character.isDigit(c)) multiplier = multiplier * 10 + Integer.valueOf("" + c);
            else if(c == '[') {
                stack.push("" + multiplier);
                stack.push("" + c);
                multiplier = 0;
            }
            else if(c == ']') {
                while(!stack.peek().equals("[")) temp.append(stack.pop());
                stack.pop();
                String evaluated = eval(Integer.valueOf(stack.pop()), temp);
                for(char ch: evaluated.toCharArray()) stack.push("" + ch);
                
                temp = new StringBuilder();
            }
            else stack.push("" + c);
        }
        
        return process(stack);
    }
    
    private String eval(int multiplier, StringBuilder str) {
        StringBuilder sb = new StringBuilder();
        String toAppend = str.reverse().toString();
        while(multiplier-- > 0) sb.append(toAppend);
        return sb.toString();
    }
    
    private String process(Stack<String> stack) {
        Stack<String> reverseStack = new Stack<>();
        while(!stack.isEmpty()) reverseStack.push(stack.pop());
        
        StringBuilder sb = new StringBuilder();
        while(!reverseStack.isEmpty()) sb.append(reverseStack.pop());
        
        return sb.toString();
    }
}
