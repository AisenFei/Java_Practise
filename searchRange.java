import java.util.Arrays;

//34. 在排序数组中查找元素的第一个和最后一个位置

/**
 * 由于要同时使用两个check函数所以两个模板都会使用到
 */
public class searchRange {

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] nums2 = new int[]{};
        nums2 = null;
        int[] search = searchRange(nums2,6);
        System.out.println(Arrays.toString(search));
    }
    public static int[] searchRange(int[] nums, int target) {
        //首先判断特例
        if(nums == null) return new int[]{-1,-1};
        if(nums.length == 0||nums[nums.length- 1] < target) return new int[]{-1,-1};

        //然后进行正常情况的处理
        int [] res = new int[]{-1,-1};
        //首先找出数字的左边界 也就是  >= 第一个值
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        //如果存在 那么就对应的更改值即可
        if(nums[left] == target){
            res[0] = left;
        }

        //然后找出右边界的最后一个
        left = 0;
        right = nums.length-1;
        while(left < right){
            int mid = (left + right+1)/2;
            if(nums[mid] <= target){
                left = mid;
            }else{
                right = mid -1;
            }
        }
        //如果存在 那么就对应的更改值即可
        if(nums[left] == target){
            res[1] = left;
        }
        return res;
    }
}
