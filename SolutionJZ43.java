<<<<<<< HEAD
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
=======
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
>>>>>>> 0380db1773777265be732f84fecc266af8412578
