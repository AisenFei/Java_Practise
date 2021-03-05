package code_2021_0301;

public class SolutionJZ43 {
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0|| n <= 0){
            return str;
        }
        n = n % str.length();
        String left = str.substring(0,n);
        String right = str.substring(n,str.length());
        return right + left;
    }
}
