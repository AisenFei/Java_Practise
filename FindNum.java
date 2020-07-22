package FindNum;

public class FindNum {
    public static void main(String[] args) {
        int[] arr = {1,3,4,3,1,2,4,5,5};
        findNum(arr);
        findNum1(arr);
    }
    //方法1
    public static void findNum(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int flag = 0;
            for (int j = 0; j < arr.length ; j++) {
                if (i != j && arr[i] == arr[j]){
                    flag = 1;
                    break;
                }
            }
            if (flag == 0){
                System.out.println("单身狗是数字："+arr[i]);
                break;
            }
        }
    }
    //方法2
    public static void findNum1(int[] arr){
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            a ^= arr[i];
        }
        System.out.println("单身狗是数字："+a);
    }
}
