package SortOddEven;

public class SortOddEven {

    public static void main(String[] args) {
        int[] arr= {1,5,3,8,7,6,4,3,6};
        sortOddEven(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void sortOddEven(int[] arr){
        int i = 0;
        int j = arr.length-1;
        while(i < j){
            while(i < j && arr[j] % 2 == 0){
                j--;
            }
            while(i < j && arr[i] % 2 != 0){
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
