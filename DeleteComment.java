package code_2020_1130;

import java.util.Scanner;

public class DeleteComment {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            char[] ch = sc.nextLine().toCharArray();
            String str = sc.nextLine();
            for(char i : ch){
                if(!str.contains(String.valueOf(i))){
                    System.out.print(i);
                }
            }
        }
    }
}
