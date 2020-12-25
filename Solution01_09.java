package code_2020_1223;

public class Solution01_09 {
    public boolean isFlipedString(String s1,String s2){
        if(s1.length() != s2.length()) return false;
        return (s2+s2).indexOf(s1) != -1;
    }
}
