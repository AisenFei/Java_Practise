package code_2021_0119;

import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int stuNum = sc.nextInt();
            int speakNum = sc.nextInt();
            int[] stuScore = new int[stuNum];
            for(int i = 0;i < stuNum;i++){
                stuScore[i] = sc.nextInt();
            }
            for(int i = 0;i < speakNum;i++){
                String str = sc.next();
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();
                if("Q".equals(str)){
                    System.out.println(getMax(stuScore,num1,num2));
                }else{
                    stuScore[num1-1] = num2;
                }
            }
        }
    }
    public static int getMax(int[] stuScore,int num1,int num2){
        int max = 0;
        for(int i = num1 - 1;i < num2;i++){
            max = max >= stuScore[i] ? max : stuScore[i];
        }
        return max;
    }
}
