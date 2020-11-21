package Set;

/*
771.宝石与石头
 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

 */

import java.util.Set;
import java.util.TreeSet;

public class JewelsAndStones {
    public int numJewelsInStones(String J,String S){
        //1.把宝石集合构成一个Set
        Set<Character> gem = new TreeSet<>();
        char[] jChars = J.toCharArray();
        for(char j:jChars){
            gem.add(j);
        }

        //2.遍历我手中的所有石头，判断是不是宝石
        int count = 0;
        char[] sChars = S.toCharArray();
        for(char s:sChars){
            if(gem.contains(s)){
                count++;
            }
        }
        return count;
    }
}
