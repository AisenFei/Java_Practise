package code_2021_0301;

import java.time.chrono.IsoChronology;
import java.util.Scanner;

public class SolutionJZ45 {
    public boolean IsContinuous(int [] numbers) {
        if(numbers.length < 5)return false;
        for(int i = 1;i < 5;i++){
            for(int j = i;j > 0;j-- ){
                if(numbers[j-1] > numbers[j]){
                    int temp = numbers[j-1];
                    numbers[j-1] = numbers[j];
                    numbers[j] = temp;
                }else {
                    break;
                }
            }
        }
        int zeroNum = 0;
        int ans = 0;
        for(int i = 0;i < 4;i++){
            if(numbers[i] == 0){
                zeroNum++;
                continue;
            }
            if(numbers[i] == numbers[i+1]){
                return false;
            }
            ans = ans + numbers[i+1] - numbers[i] - 1;
        }
        if(ans > zeroNum){
            return false;
        }
        return true;
    }
}
