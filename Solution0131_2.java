package code_2021_0127;
import java.util.Scanner;
public class Solution0131_2 {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        while(sc.hasNextLine()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i < n;i++){
                arr[i] = sc.nextInt();
            }
            for(int i = 0; i < n;i++){
                int left = i - 1;
                int right = i + 1;
                for(;left >= 0;left--){
                    if(arr[i] > arr[left]){
                        break;
                    }
                }
                for(;right < n;right++){
                    if(arr[i] > arr[right]){
                        break;
                    }
                }
                if(right == n){
                    right = -1;
                }
                System.out.println(left+" "+right);
            }
        }
    }
}
