package code_2021_0203;
import java.util.Scanner;
//字母统计
public class WordNum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            int[] arr = new int[26];
            for(char c : s.toCharArray()){
                if(c >= 'A' && c <= 'Z'){
                    int n = (int)(c-'A');
                    arr[n]++;
                }
            }
            char word = 'A';
            for(int i = 0;i < arr.length;i++){
                System.out.println(word+":"+arr[i]);
                word++;
            }
        }
    }
}
