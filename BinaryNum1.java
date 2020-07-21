package BinaryNum1;

import java.util.Scanner;

public class BinaryNum1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int count = 0;
        while(num != 0){
            count++;
            num &= num - 1;
        }
        /*while(num != 0){
            if((num & 1) == 1){
                count++;
            }
            num >>>= 1;
        }*/
        System.out.println(num + "的二进制序列中1的个数为：" + count);
    }
}
