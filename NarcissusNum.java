package NarcissusNum;

public class NarcissusNum {
    public static void main(String[] args) {
        int num = 100;
        while(num < 1000){
            if(num == (num/100)*(num/100)*(num/100)
                    + ((num % 100)/10)*((num % 100)/10)*((num % 100)/10)
                    + (num % 10)*(num % 10)*(num % 10)){
                System.out.println(num);
            }
            num++;
        }
    }
}
