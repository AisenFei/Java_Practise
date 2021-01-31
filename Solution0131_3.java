package code_2021_0127;

import java.util.*;

public class Solution0131_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0; i < n;i++){
                int num = sc.nextInt();
                map.put(num,map.getOrDefault(num,0)+1);
            }
            int[] arr = new int[2];
            int i = 0;
            for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                if(entry.getValue() == 1){
                    arr[i] = entry.getKey();
                    i++;
                }
            }
            if(arr[0] > arr[1]){
                arr[0] ^= arr[1];
                arr[1] ^= arr[0];
                arr[0] ^= arr[1];
            }
            System.out.println(arr[0]+" "+arr[1]);
        }
    }
}
