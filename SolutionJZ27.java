package code_2021_0301;

public class SolutionJZ27 {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0){
            return -1;
        }
        int[] ans = new int[58];
        for(int i = 0;i < str.length();i++){
            ans[str.charAt(i) - 'A']++;
        }
        for(int i = 0;i < str.length();i++){
            if(ans[str.charAt(i)-'A'] == 1){
                return i;
            }
        }
        return -1;
    }
}
