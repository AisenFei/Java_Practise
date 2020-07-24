package ArrayMul;

import java.util.Arrays;

public class ArrayMul {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        /*arrMul(arr);
        System.out.println(Arrays.toString(arr));*/
        System.out.println(avg(arr));
        transform(arr);
        System.out.println(Arrays.toString(arr));
        printArray(arr);
        int[] arr1 = new int[100];
        for (int i = 0; i < arr1.length ; i++) {
            arr1[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr1));
    }

    public static int avg(int[] arr){
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return sum;
    }
    public static int[] arrMul(int[] array){
        int[] arr1 = new int[array.length];
        for (int i = 0; i <array.length ; i++) {
            arr1[i] = array[i]*2;
        }
        return arr1;
    }
    public  static void transform(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            arr[i] *= 2;
        }
    }
    public static void printArray(int[] arr){
        for (int x:arr) {
            System.out.print(x + " ");
        }
    }
}
