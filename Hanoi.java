package Hanoi;

import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        hanoi('A','B','C',n);
    }
    public static void hanoi(char a,char b,char c,int n){
        if (n == 1){
            System.out.println(a +"->" + c);
        }else{
            hanoi(a,c,b,n - 1);
            System.out.println(a + "->" + c);
            hanoi(b,a,c,n-1);
        }
    }
}
