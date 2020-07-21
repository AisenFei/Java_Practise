package PriNum;

import java.util.Scanner;

public class PriNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        PriNums(num);
    }
    public static void PriNums(int num){
        if (num < 10){
            System.out.print(num);
        }else {
            PriNums(num/10);
            System.out.printf(", " + (num % 10));
        }
    }
}
