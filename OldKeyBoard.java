package Set;

/*
输入描述：
输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，由字母A-Z（包括大、小写）、数字0-9、
以及下划线“_”（代表空格）组成。题目保证2个字符串均非空。

输出描述：
按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有1个坏键。

 */

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class OldKeyBoard {
    public static void main(String[] args){
        //1.读取实际输入和看到的输出
        Scanner sc = new Scanner(System.in);
        String TheTrueSc = sc.nextLine();
        String TheTrueSee = sc.nextLine();

        //2.为了方便比较，将所有字符统一转换成大写处理
        TheTrueSc = TheTrueSc.toUpperCase();
        TheTrueSee = TheTrueSee.toUpperCase();

        //3.将看到输出组织成一个Set集合(方便查找-提高查找时间复杂度）
        Set<Character> TheTrueSee2 = new TreeSet<>();
        for(char ch:TheTrueSee.toCharArray()){
            TheTrueSee2.add(ch);
        }

        //4.准备好一个错误案件Set集合（用于去重）
        Set<Character> wrongChar = new TreeSet<>();

        //5.遍历实际输入的每一个字符，如果没有在看到输出中，就表示是一个错误按键
        for(char ch:TheTrueSc.toCharArray()){
            if(!TheTrueSee2.contains(ch)){
                //说明ch 是错误的
                if(!wrongChar.contains(ch)){
                    //说明ch是刚发现的一个UC哦呜
                    //6.保证按照实际输入的顺序，输出错误案件
                    System.out.print(ch);
                    wrongChar.add(ch);
                }
            }
        }
        System.out.println();
    }
}
