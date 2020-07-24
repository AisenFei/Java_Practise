package FactorialSum;

import java.util.Scanner;

public class FacSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(facNum(n));
        System.out.println(facNum1(n));
    }

    //递归
    public static int facNum1(int n){
        if(n == 1){
            return 1;
        }
        return n*facNum1(n -1);
    }

    //迭代
    public static int facNum(int n){
        int num = 1;
        for (int i = 1; i <= n; i++) {
            num *= i;
        }
        return num;
    }
    /*public static void facSum(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int facNum = 1;
            for (int j = 1; j <= i; j++) {
                facNum *= j;
            }
            sum += facNum;
        }
        System.out.println(sum);
    }*/
}
