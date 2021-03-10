package code_2021_0301;

import java.util.ArrayList;

public class Solution2021_0310_1 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(input.length == 0 || k > input.length){
            return arrayList;
        }
        for(int i = 1;i < input.length;i++){
            for(int j = i;j > 0;j--){
                if(input[j] < input[j - 1]){
                    int temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                }else{
                    break;
                }
            }
        }
        for(int i = 0;i < k;i++){
            arrayList.add(input[i]);
        }
        return arrayList;
    }
}
