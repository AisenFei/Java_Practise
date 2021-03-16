package code_2021_0314;

public class Solution59 {
    public static int[][] generateMatrix(int n) {
        int l = 0,r = n - 1,t = 0, b = n - 1;
        int[][] arr = new int[n][n];
        int num = 1,tar = n * n;
        while(num <= tar){
            for(int i = l;i <= r;i++)arr[t][i] = num++;
            t++;
            for(int i = t;i <= b;i++)arr[i][r] = num++;
            r--;
            for(int i = r;i >= l;i--)arr[b][i] = num++;
            b--;
            for(int i = b;i >= t;i--)arr[i][l] = num++;
            l++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = generateMatrix(3);
        for(int[] array : arr){
            for(int n : array){
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }
}
