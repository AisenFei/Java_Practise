package MaxOverride;

public class MaxOverride {
    public static void main(String[] args) {
        int a = 17;
        int b = 11;
        double c = 11.5;
        double d = 16.2;
        System.out.println(maxNum(a,b));
        System.out.println(maxNum(c,d));
        System.out.println(maxNum(c, d, a));
    }
    public static int maxNum(int x,int y){
        return x > y ? x : y;
    }
    public static double maxNum(double x,double y){
        return x > y ? x : y;
    }
    public static double maxNum(double x,double y,int z){
        return maxNum(x,y) > z ? maxNum(x,y) : z;
    }
}
