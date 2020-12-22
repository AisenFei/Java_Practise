package code_2020_1222;
//面试题01.02，判定是否为字符重排
public class Solution01_02 {
    public boolean CheckPermutation(String s1,String s2){
        int len1 = s1.length(),len2 = s2.length();
        if(len1 != len2) return false;
        int[] hash = new int[128];
        for(int i = 0;i < len1;i++){
            hash[s1.charAt(i)]++;
            hash[s2.charAt(i)]--;
        }
        for(int i = 0;i < 128;i++){
            if(hash[i] != 0){
                return false;
            }
        }
        return true;
    }
}
