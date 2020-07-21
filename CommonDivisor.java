package CommonDivisor;

import java.util.Scanner;

public class CommonDivisor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = 0;
        while(a % b != 0){
            c = a % b;
            a = b;
            b = c;
        }
        System.out.println("最大公约数位：" + b);
    }
}
