//153. 寻找旋转排序数组中的最小值v
// 画出图示设计check函数
public class findMin {
    public int findMin(int[] nums) {
        if(nums == null) return -1;
        int left = 0;
        int right = nums.length-1;
        int target = nums[right];
        int mid = 0;
        while(left < right){
            mid = (left + right)/2;
            if(nums[mid] <= target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return nums[left];
    }
}
