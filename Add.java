package Add;

import java.util.Scanner;

public class Add {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = add(n);
        System.out.println(sum);

        /*int n = sc.nextInt();
        int sum = addN(n);
        System.out.println(sum);*/
    }
    public static int add(int n){
        if(n == 1){
            return 1;
        }
        return n + add(n-1);
    }
    public static int addN(int n){
        if (n < 10){
            return n;
        }
        return n%10 + addN(n/10);
    }
}
