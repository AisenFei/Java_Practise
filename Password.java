package code_2021_0119;
import java.util.Scanner;
public class Password {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            char[] charArr = str.toCharArray();
            for(char c : charArr){
                if(c >= 'A' && c <= 'Z'){
                    System.out.print((char)((c-'A'+5)%26+'A'));
                }else{
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }
}
