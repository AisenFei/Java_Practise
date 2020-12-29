package code_2020_1223;

//面试题03_02,栈最小值
import java.util.Stack;

class MinStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if(stack2.isEmpty() || stack2.peek() >= x){
            stack2.push(x);
        }
        stack1.push(x);
    }

    public void pop() {
        if(stack1.pop() == getMin()){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
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