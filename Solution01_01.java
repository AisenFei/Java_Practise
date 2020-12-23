package code_2020_1223;

public class Solution01_01 {
    public boolean isUnique(String astr) {
        int len = astr.length();
        int[] hash = new int[128];
        for(int i = 0; i < len;i++){
            hash[astr.charAt(i)]++;
        }
        for(int i = 0;i < 128;i++){
            if(hash[i] > 1){
                return false;
            }
        }
        return true;
    }
}
