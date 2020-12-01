package code_2020_1125;

import java.util.Arrays;
import java.util.Random;

public class Sort1 {
    public static void insert(int[] array){
        //数据一共有array.length个
        //所以，外部循环总共需要执行array.length - 1次
        for(int i = 0;i < array.length - 1;i++){
            //有序[0,i]
            //无序[i + 1,array.length)
            //需要从无序区间拿出来往有序区间插入的数下标为[i+1]
            int key = array[i + 1];

            //依次在有序区间进行比较,从i到0
            int j;
            for(j = i;j >= 0;j--){
                //[j]就是需要和key进行比较的数
                if(key < array[j]){
                    array[j + 1] = array[j];
                }else{
                    break;
                }
            }
            array[j + 1] = key;
        }
    }

    //测试四种情况
    //1.随机生成的乱序数
    //2.已经有序
    //3.已经逆序
    //4.完全相等
    //5.测试不同规模的数据

    public static int[] randomArray(){//随机
        Random random = new Random(20201125);
        int[] array = new int[10];
        for(int i = 0; i < 10;i++){
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static int[] youXuArray(){//有序数组
        int[] array = randomArray();
        Arrays.sort(array);
        return array;
    }

    public static void main(String[] args){
        int[] a1= randomArray();
        System.out.println(Arrays.toString(a1));
        shellSort(a1);
        System.out.println(Arrays.toString(a1));
    }

    public static void bubbleSort(int[] array){
        for(int i = 0;i < array.length - 1;i++){
            boolean flag = true;
            for(int j = 0;j < array.length - i - 1;j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = false;
                }
            }
            if(flag){//flag 为真说明该轮冒泡没有交换元素，即整个区间有序
                break;
            }
        }
    }

    public static void selectSort(int[] array){
        for(int i = 0;i < array.length - 1;i++){
            int maxIndex = 0;//假设无序区间最大值为array[0]
            int j;
            for(j = 1;j < array.length - i;j++){
                if(array[maxIndex] < array[j]){
                    maxIndex = j;
                }
            }
            int temp = array[array.length - i - 1];
            array[array.length - i - 1] = array[maxIndex];
            array[maxIndex] = temp;
        }
    }

    public static void shellSort(int[] array){
        int gap = array.length/2;
        while(gap > 1){
            insertSortGap(array,gap);
            gap = gap/2;
        }
        insertSortGap(array,gap);
    }

    private static void insertSortGap(int[] array,int gap){
        for(int i = gap; i < array.length;i++){
            int key = array[i];
            int j;
            for(j = i - gap;j >= 0 && array[j] > key;j -= gap){
                array[j+gap] = array[j];
            }
            array[j+gap] = key;
        }
    }
}
