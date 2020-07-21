package OddEven;

import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num =scan.nextInt();
        System.out.println("偶数序列：");
        for (int i = 31; i > 0; i -= 2) {
            System.out.print((num >> i) & 1);
        }
        System.out.println();
        System.out.println("奇数序列：");
        for (int i = 30; i >= 0; i -= 2) {
            System.out.print((num >> i) & 1);
        }
    }
}
