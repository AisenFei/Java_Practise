package code_2021_0119;

import java.util.Deque;
import java.util.LinkedList;

class Solution150 {
    public static void main(String[] args) {
        String[] tokens = new String[]{"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        Integer a,b;
        for(String s : tokens){
            if(s.equals("+")){
                a = stack.pop();
                b = stack.pop();
                stack.push(b+a);
            }else if(s.equals("-")){
                a = stack.pop();
                b = stack.pop();
                stack.push(b-a);
            }else if(s.equals("*")){
                a = stack.pop();
                b = stack.pop();
                stack.push(b*a);
            }else if(s.equals("/")){
                a = stack.pop();
                b = stack.pop();
                stack.push(b/a);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}