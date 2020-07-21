package num9;

public class Num9 {
    /**
     * 版本1，for循环
     * @param args
     */
    public static void main1(String[] args) {
        int num = 0;
        for (int i = 1; i <= 100; i++) {
            if(i % 10 == 9){
                num++;
            }
            if (i / 10 == 9){
                num++;
            }
        }
        System.out.println("1~100数字9的个数是："+ num);
    }

    /**
     * 版本2，while循环
     * @param args
     */
    public static void main(String[] args) {
        int i = 1;
        int allOfNum9 =0;
        while(i <= 100){
            if(i % 10 == 9){
                allOfNum9++;
            }
            if (i / 10 == 9){
                allOfNum9++;
            }
            i++;
        }
        System.out.println("1~100数字9的个数是："+ allOfNum9);
    }
}
