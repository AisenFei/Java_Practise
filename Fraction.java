package Fraction;

public class Fraction {
    public static void main(String[] args) {
        double result = 0.0;
        double i,n = 1;
        for (i = 1; i <= 100; i++) {
            result += n/i;
            n = -n;
        }
        System.out.println("result = " + result);
    }
}
