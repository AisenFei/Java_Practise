package code_2020_1215;
//面试题01.05 一次编辑
public class Solution01_05 {
    public boolean oneEditAway(String first, String second){
        int len1 = first.length();
        int len2 = second.length();
        if(Math.abs(len1 - len2)>1) return false;
        if(len2 > len1) return oneEditAway(first,second);
        for(int i = 0;i < len2;i++){
            if(first.charAt(i) != second.charAt(i)){
                return first.substring(i + 1).equals(second.substring(len1 == len2 ? i+1 : i));
            }
        }
        return true;
    }
}
