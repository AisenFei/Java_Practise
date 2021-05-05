package day12;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//581. 最短无序连续子数组
//左边是一个有序数组 中间是一个无序数组 右边有序数组
//满足对中间的无序数组排序完之后，整个数组呈现出有序的状态
//无序数组的所有值大于左边有序数组的最大值
//无序数组的所有值小于右边有序数组的最小值
public class findUnsortedSubarray {
    public static void main(String[] args) {
        int [] arr = {1,3,5,4,2};
        System.out.println(solution2(arr));

    }

    /**
     * 题目的本质就是找 有序数组和无序数组的边界问题
     *
     * 利用上面分析的特性 维护一个单调递增栈
     * 如果遇到的数组大小一直是升序的，那么就将下标不断的压入栈中，
     * 一旦遇到一个比栈顶元素小的，那么就不断的弹出栈顶元素，直到栈顶元素比该元素小
     * 此时栈顶的下标是 k  那么无序数组的左边界就是k+1
     *
     * 右边界是反之  维护的是一个单调递减的栈
     *
     *
     * [1,3,5,4,2]
     * 输出：
     * 3
     * 预期结果：
     * 4
     *
     *
     */
    public static int solution2(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int left = nums.length-1;//注意这里，先假定整个数组是有序的，然后开始不断地缩小下标
        int right = 0;
        for(int i =0 ;i <nums.length;i++){
            //如果栈是空的将元素的下标压入栈
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]){
                left = Math.min(left,stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for(int j = nums.length-1; j >= 0;j--){
            //如果比栈顶元素大，需要出栈
            while (!stack.isEmpty() && nums[j] > nums[stack.peek()]) {
                right = Math.max(right,stack.pop());
            }
            stack.push(j); //栈是空的
        }

        //出来之后需要对left 和 right 进行判断
        if(left >= right) return 0;
        return right-left+1;
    }
    /**
     * 最简单的解法就是，把数组先排序
     * 然后和现在的数组比较，比较之后，
     * 分别从左到右找和从右到左找
     * 找到到第一个不一样的，就是确定的区间
     * 空间复杂度 o（n)
     * 时间复杂度 o(log n)
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        int[] arr = nums.clone();//将原来的数组拷贝一份
        Arrays.sort(arr);
        int left = 0 ;
        int right = arr.length-1;
        while(left <= right){
            while (left <= right && arr[left] == nums[left]){
                left++;
            }
            while (left <= right && arr[right] == nums[right]){
                right--;
            }
            //跳出循环有两种可能
            //一种是找到了
            //还有一种就是没找到，都一样，不满足left<= right跳出
            if(left <= right) return right - left+1;
        }
        return 0;

    }
}

 /*for(int i =0 ;i <nums.length;i++){
        //如果栈是空的将元素的下标压入栈
        if(stack.isEmpty() ){
        stack.push(i);
        }else {
        //如果比栈顶大
        if(nums[i] >= nums[stack.peek()]){
        stack.push(i);
        }else {//说明比栈顶大--就需要一直弹出栈顶元素
        while (!stack.isEmpty() && nums[i] < nums[stack.peek()]){
        stack.pop();
        }
        //到这里就可以出栈了
        break;
        }
        }
        }
        if(!stack.isEmpty()){
        left = stack.peek()+1;
        }
        stack.clear();*/
