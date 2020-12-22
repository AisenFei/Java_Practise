package code_2020_1222;
//面试题01.03,URL化
public class Solution01_03 {
    public String replaceSpaces(String S,int length){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < length;i++){
            char c = S.charAt(i);
            if(c != ' '){
                sb.append(c);
            }else{
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}
