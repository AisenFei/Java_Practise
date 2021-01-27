package code_2021_0127;

import java.util.Scanner;

public class Solution0127_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i < n;i++){
                arr[i] = sc.nextInt();
            }
            int temp = sc.nextInt();
            boolean flag = true;
            for(int i = 0;i < n;i++){
                if(temp == arr[i]){
                    System.out.println(i);
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(-1);
            }
        }
    }
}
