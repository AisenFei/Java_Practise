<<<<<<< HEAD
package code_2020_1127;

import java.util.Stack;

public class Parenthesis {
    public boolean chkParenthesis(String A,int n){
        if(A == null || n%2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < n;i++){
            if(A.charAt(i) == '('){
                stack.push(A.charAt(i));
            }else if(A.charAt(i) == ')'){
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}
=======
package code_2020_1127;

import java.util.Stack;

public class Parenthesis {
    public boolean chkParenthesis(String A,int n){
        if(A == null || n%2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < n;i++){
            if(A.charAt(i) == '('){
                stack.push(A.charAt(i));
            }else if(A.charAt(i) == ')'){
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}
>>>>>>> 82d98bcfceef3476fc5d68dd326893acfe94e606
