package FrogJump;

import java.util.Scanner;

//一只青蛙一次可以跳上 1 级台阶，也可以跳上2 级。求该青蛙跳上一个n 级的台阶总共有多少种跳法
public class FrogJump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(frogJump(n));
    }
    public static int frogJump(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return frogJump(n - 1) + frogJump(n - 2);
    }
}
