package AddOverride;

public class AddOverride {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        double c = 12.3;
        double d = 15.1;
        double e = 13.7;
        System.out.println(myAdd(a, b));
        System.out.println(myAdd(c, d, e));
    }
    public static int myAdd(int a,int b){
        return a + b;
    }
    public static double myAdd(double x,double y,double z){
        return x + y + z;
    }
}
