package code_2021_0119;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SearchPeople {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        while(sc.hasNextLine()){
            int n1 = Integer.parseInt(sc.nextLine());
            String[] str1 = sc.nextLine().split(" ");
            Set<String> set = new HashSet<>();
            for(String str : str1){
                set.add(str);
            }
            int n2 = Integer.parseInt(sc.nextLine());
            String[] str2 = sc.nextLine().split(" ");
            int[] ansArr = new int[n1];
            for(int i = 0;i < n2;i++){
                for(int j = 0;j < set.size();j++){
                    if(set.equals(str2[i])){
                        ansArr[j]++;
                        break;
                    }
                }
            }
            int invalid = 0;
            for(int i = 0;i < n1;i++){
                System.out.println(str1[i]+" : "+ansArr[i]);
                invalid += ansArr[i];
            }
            System.out.println("Invalid : "+invalid);
        }
    }
}