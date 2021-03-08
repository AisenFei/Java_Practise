package code_2021_0301;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2021_0308 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < n;i++){
                if(sc.nextInt() == 1){
                    list.add(sc.nextInt());
                }else{
                    int index = list.indexOf(sc.nextInt());
                    list.remove(index);
                }
                if(isOk(list)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }
    }
    public static boolean isOk(List<Integer> list){
        if(list.size() < 3){
            return false;
        }
        int sum = 0, max_num = 0;
        for(Integer num : list){
            if(num > max_num){
                max_num = num;
            }
            sum += num;
        }
        if(sum - max_num <= max_num){
            return false;
        }
        return true;
    }
}
