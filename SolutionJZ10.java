<<<<<<< HEAD
package code_2021_0301;

public class SolutionJZ10 {
    public int rectCover(int target) {
        if(target == 0 || target == 1 || target == 2)return target;
        int a = 1, b = 2, c = 0;
        for(int i = 3;i <= target;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
=======
package code_2021_0301;

public class SolutionJZ10 {
    public int rectCover(int target) {
        if(target == 0 || target == 1 || target == 2)return target;
        int a = 1, b = 2, c = 0;
        for(int i = 3;i <= target;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
>>>>>>> 0380db1773777265be732f84fecc266af8412578
