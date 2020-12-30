package code_2020_1223;
//面试题，不用加号的加法
public class Solution17_01 {
    public int add(int a, int b) {
        if(b == 0)return a;
        return add(b^a, (a&b)<<1);
    }
}
