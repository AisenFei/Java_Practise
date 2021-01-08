package code_2021_0104;

public class Solution16_07 {
    public int maximum(int a, int b) {
        // double c = a;
        // double d = b;
        // int res = (int) ((Math.abs(c-d) + c + d)/2);
        // return res;

        long c = a;
        long d = b;
        int res = (int) ((Math.abs(c-d) + c + d)/2);
        return res;
    }
}
