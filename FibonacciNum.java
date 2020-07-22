package Fibonacci;

import java.util.Scanner;

public class FibonacciNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(fibo(n));
    }
    public static void fiboNum(int n){
        if (n == 1){
            System.out.println(1);
        }else if (n == 2){
            System.out.println(1);
        }else {
            int a = 1;
            int b = 1;
            int c = 0;
            for (int i = 0; i < n - 2; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            System.out.println(c);
        }
    }
    public static int fibo(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
}
