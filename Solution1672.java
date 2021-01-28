package code_2021_0127;

public class Solution1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        int temp = 0;
        for(int i = 0;i < accounts.length;i++){
            for(int j = 0;j < accounts[0].length;j++){
                temp += accounts[i][j];
            }
            max = max > temp ? max : temp;
            temp = 0;
        }
        return max;
    }
}
