package day09;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class removeDuplicateLetters {
    /**
     * 要求一：去重
     * 要求二：按照原来的顺序
     * 要求三：字典序(单调栈)
     * @param
     *  @return
     */
    public static void main(String[] args) {
        solution("cdadabcc");
    }
    public  static String solution (String s) {
        //用栈来实现去重和字典序的
        Deque<Character> stack =new LinkedList<>();//这个栈用来存放去重的结果
        //用map来统计每一个人字符出现的次数 之后在元素出栈的时候可以使用它
        //map 保留的是当前字符串之后是否还有这个元素。
        Map<Character,Integer> map = new HashMap<>();

        for(Character c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(Character c : s.toCharArray()){
            if(stack.contains(c)){
                map.put(c,map.get(c)-1);//因为我最后看的是剩下字符串里面话有没有
                continue;//如果栈里面存在这个元素，那么就跳过

            }
            //在插入之前和栈里面的元素比较一下
            //如果字典顺序小，之前的就先弹出
            //但是出栈的时候，还要再次判断是否之后还会再次出现
            //所以用一个map记录一下每一个元素的次数
            while (!stack.isEmpty() && c < stack.peek()){


                //不断地弹出栈顶元素，然后找到当前字符应该出现的位置
                //但是在弹出栈顶元素的时候，还应该确定之后是还会有这个元素
                if(map.get(stack.peek()) > 1){//如果之后还有，还可以继续除出栈
                    //然后更新map的值
                    map.put(stack.peek(),map.get(stack.peek())-1);
                    stack.pop();

                }else {
                    break;//如果只剩一个就不可以继续弹出。
                }

            }
            stack.push(c);

        }

        //之后出栈然后逆序输出
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
