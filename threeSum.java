package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//15. 三数之和
public class threeSum {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,0,1,1,2};
        threeSum(arr);

    }

    /**
     * 使用排序 + 双指针
     * 为什么使用排序 就是为了让相同的元素在一起 然后检索的时候可以跳过相同的元素，避免重复判断
     * 为什么使用双指针  让双指针的指向的位置的和 等于某一个目标值
     *      由于本题是三数之和等于0 那么变向的说就是 两数之和是另一个数的相反数
     *      所以双指针的值的和就是另一个数的相反数
     * @param nums
     * @return
     */
    public  static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        //排除特殊的情况
       if(nums == null || nums.length < 3){
           return res;
       }
       Arrays.sort(nums);
       //开始遍历元素
        for(int i = 0;i < nums.length;i++){
            //要保证接下来去操作的元素和前一个元素不一样
            //不然会产生相同的  为什么保证一个元素不一样就可以做到？
            if(i > 0 && nums[i] == nums[i-1]) continue;

            //在这里进行双指针的操作
            int left = i+1;
            int right = nums.length-1;
            while (left < right){ // 处理可能因为for和内部处理越界的情况
                int target = -nums[i]; // 这就是左右指针指向元素的和
                if(nums[left]+ nums[right] == target){
//                    LinkedList<Integer> temp = new LinkedList<>();
////                    temp.add(nums[i]);
////                    temp.add(nums[left]);
////                    temp.add(nums[right]);
////                    res.add(temp);
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    //现在要增加 left，减小 right，但是不能重复
                    //首先无论如何先要进行加减操作
                    left++;
                    right--;
                    //这里有一个特殊的情况需要排除
                    // -3 1 1 2 2 这样的做法会出现重复添加的问题
                    //所以一定要保证 之后的left right和这次加入到list里面left和right不一样才可以
                    while (left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while (left <right && nums[right] == nums[right+1]){
                        right--;
                    }
                }else if(nums[left]+ nums[right]  > target){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return res;
    }

}
