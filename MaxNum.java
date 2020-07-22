package MaxNum;

import java.util.Scanner;

public class MaxNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        c = maxNum(a,b,c);
        System.out.println(c);
    }
    public static int maxNum(int x,int y){
        return x > y ? x : y;
    }
    public static int maxNum(int x,int y,int z){
        return maxNum(x,y) > z ? maxNum(x,y) : z;
    }
}
