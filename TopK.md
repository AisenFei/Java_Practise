# TopK

剑指Offer40.最小的k个数，昨天想好的今天就写这道题，不过得用多种方式写出来，所以也算写了五道题，哈哈哈哈。

![image-20210416195848476](C:\Users\高飞\AppData\Roaming\Typora\typora-user-images\image-20210416195848476.png)

## 方式一：普通快排

解析过程：

> 其实这道题一眼看下去，最直接的方法就是对整个区间进行排序，然后再去输出前k个元素就完成了。快排的时间复杂度是O(nlogn)。
>
> 那么我们来回顾一下快排？
>
> 整体思路就是选一个元素，将小的放在其左面，大的放在其右面，然后递归执行，直到每个区间有序，使得整个区间有序。最难的也就是这个partition过程了，具体讲解在我的博客排序算法里都有。

代码实现：

```java
public class TopK {
     //方式一：最直接方法，先将整体排序，再输出前k个元素，直接使用快排
     public int[] getLeastNumbers(int[] arr, int k) {
         quickSort(arr,0,arr.length-1);
         int[] res = new int[k];
         for(int i = 0; i < k;i++){
             res[i] = arr[i];
         }
         return res;
     }

     public static void quickSort(int[] arr,int left,int right){
         if(left >= right)return;
         int i = left,j = right;
         while(i < j){
             while(i < j && arr[j] >= arr[left])j--;
             while(i < j && arr[i] <= arr[left])i++;
             swap(arr,i,j);
         }
         swap(arr,i,left);
         quickSort(arr,left,i-1);
         quickSort(arr,i+1,right);
     }
     public static void swap(int[] arr,int i,int j){
         int temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
     }
}
```

## 方式二：快排思想

解析过程：

> 有了上面的铺垫，那么方式二才算正式的解题。
>
> 因为我们只需要输出前k个元素，而无需对其进行排序，那么快排就是这样的过程啊。我们只要找到k对应的基准值(i)，那么也就找到了前k个元素了。
>
> 1. k == i，说明前k个元素都小于基准值，也就是topK了。
> 2. k < i，说明前k个元素还在左   ;半个区域，那么就继续对左半部分快排。
> 3. k > i，说明前k个元素在右半个区域，对右半部分进行快排。
>
> 这时候我们去分析时间复杂度，第一次是N，第二次

代码实现:

```java
public int[] getLeastNumbers(int[] arr, int k) {
         if(k >= arr.length)return arr;
         return quickSort(arr,0,arr.length-1,k);
     }
     public static int[] quickSort(int[] arr,int left,int right,int k){
         int i = left,j = right;
         while(i < j){
             while(i < j && arr[j] >= arr[left])j--;
             while(i < j && arr[i] <= arr[left])i++;
             swap(arr,i,j);
         }
         swap(arr,i,left);
         if(i > k)return quickSort(arr,left,i-1,k);
         if(i < k)return quickSort(arr,i+1,right,k);
         return Arrays.copyOf(arr,k);
     }
     public static void swap(int[] arr,int i,int j){
         int temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
     }
```

## 方式三：堆排

解析过程：

> 堆排的思想是先