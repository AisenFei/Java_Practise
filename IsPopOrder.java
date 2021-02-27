package Stack;

import java.util.Deque;
import java.util.LinkedList;

//栈的压入弹出序列
//牛客的剑指offer
public class IsPopOrder {
    //不断地让pushA压栈
    //同时比较和popA数组的第一个元素比较大小
    //如果相同就栈出栈 然后popA继续往后面挪动一个
    //如果不相同 就继续压栈，直到pushA中的所有元素都压入
    //最后判断栈是否为空
    public boolean IsPopOrder(int [] pushA,int [] popA){
        Deque<Integer> stack = new LinkedList<>();
        int popIndex = 0;//记录出栈序列的下标遍历的位置
        for(int i =0;i < pushA.length;i++){
            //不断的让元素入栈
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
    /**
     * 把弹出的序列压入栈
     * 两个数组
     * 让popA 的第一个元素和栈顶的元素作比较--这个操作是一个循环的步骤
     * 1.栈为空--执行入栈的操作（如果pushA里面还有元素）
     * 2.和栈顶元素相同（栈弹出，然后继续往后比较）
     * 3.和栈顶元素不同--（在pushA数组还有元素的情况下继续压栈
     *
     * 最终如果栈里面还有元素的话，但是pushA已经遍历完了，那么就是序列不可以
     * @param pushA 压入序列
     * @param popA 弹出序列
     * @return
     */

}
