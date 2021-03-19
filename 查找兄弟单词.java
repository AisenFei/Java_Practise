package day45;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
/*
难点在于
1.如何判断两个单词是不是兄弟字符串
首先是长度必须一样 其次是两个字符串不能一样
这里的做法是把两个字符串转成成字符数组然后进行排序
排序之后一个个的比较
如果全部都一样，才说明是一个兄弟字符串
2. 获取的兄弟字符串的个数 是否会出现越界的问题
通俗来讲就是 你要获取第几个字符串是不是根本就没有那么多个

 */

public class 查找兄弟单词 {
    //这个是用来保存所有数据的
    private static LinkedList<String> linkedList = new LinkedList<>();
    //这个是用来保存 brotherList的
    //但是因为这个 brotherList 其实是和 每一次输入相关的
    //但是这里处理成了只有一次输入 所以这是做的不好的地方
    private static LinkedList<String> brotherList = new LinkedList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int  number = sc.nextInt();

        while (number > 0) {
            //进行数据录入，它的顺序不一定是排序过的，所以需要重新进行按照字典序排序
            linkedList.add(sc.next());
            number--;
        }
        //它就会帮你按照字典序进行排序的
        Collections.sort(linkedList);


        //查找的单词在字典中兄弟单词的个数
        String str = sc.next();
        int count = isBrother(str,linkedList);
        System.out.println(count);
        //找它的字典顺序
        int sequence = sc.nextInt();
        //这里一定要进行判断 的否则如果输入的数字比兄弟单词的数量大就错了
        if(sequence <=  brotherList.size()){
            //如果要查找的兄弟单词的排序大于count
            System.out.println(brotherList.get(sequence - 1));
        }
    }

    //兄弟单词的性质
    //1.单词的长度一样 并且单词的的每一个字母都有
    //2.相同的单词不是兄弟单词 只是相同单词
    //但是这样的话就是会完整的遍历一遍
    private static int isBrother(String str, LinkedList<String> list) {
        int count = 0;//用来统计兄弟单词的个数
        int length  = str.length();
        int size = list.size();
        for(int i = 0;i < size ;i++){
            //比较两个单词是不是字典序
            String temp = list.get(i);
            //如果长度不相等或者字符串完全相等就不是兄弟
            if(temp.length() != length || str.equals(temp)){
                continue;
            }else {
                //说明长度相等然后去判断字符是不是都一样
                //别人采用的做法是 把这两个字符都排序处理
                //然后看是否相同
                char[] arr = str.toCharArray();
                Arrays.sort(arr);
                char[] tempArr = temp.toCharArray();
                Arrays.sort(tempArr);
                //然后比较每一个字符
                int j =0;
                for(;j < arr.length;j++){
                    if(arr[j] != tempArr[j]){
                        break;
                    }
                }
                if(j == arr.length){
                    //说明是因为比较完全了以后退出的循环
                    count++;
                    //把这个单词加入它的兄弟单词
                    brotherList.add(temp);
                }
            }
        }
        return count;
    }
}
