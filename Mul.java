package Mul;

import java.util.Scanner;

public class Mul {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.printf("%d*%d=%d ",j,i,j*i);
            }
            System.out.println();
        }
    }
}
