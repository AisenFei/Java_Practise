package ArrayMax;

public class ArrayMax {
    public static void main(String[] args) {
        int[] arr = {1,5,7,3,2};
        System.out.println(arrayMax(arr));
    }
    public static int arrayMax(int[] arr){
        if (arr == null || arr.length == 0){
            return -1;
        }
        int max = 0;
        for (int x:arr) {
            if (max < x){
                max = x;
            }
        }
        return max;
    }
    public static double arrayAve(int[] arr){
        if (arr == null || arr.length == 0){
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum*1.0/arr.length;
    }
}
