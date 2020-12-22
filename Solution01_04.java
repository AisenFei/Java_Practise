package code_2020_1222;

//面试题01.04,回文排列
import java.util.HashSet;
import java.util.Set;

public class Solution01_04 {
    public boolean canPermutePalindrome(String s){
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(!set.add(c)){
                set.remove(c);
            }
        }
        return set.size() <= 1;
    }
}
