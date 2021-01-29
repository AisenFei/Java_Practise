package code_2021_0127;
import java.util.Scanner;
public class Solution0129_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            double ans = nobodyNum(n)/(double)totalNum(n)*100;
            System.out.println(String.format("%.2f",ans)+"%");
        }
    }
    public static int nobodyNum(int n){
        if(n == 1){
            return 0;
        }else if(n == 2){
            return 1;
        }else{
            return (n-1)*(nobodyNum(n-1) + nobodyNum(n-2));
        }
    }
    public static int totalNum(int n){
        if(n == 1 || n == 0){
            return 1;
        }
        return n*totalNum(n - 1);
    }
}