/**
 * 这个题尝试使用 不同的check函数来进行二段性的区间的判定
 *
 * 边界出现问题就是
 * 1.数组不指向任何引用 那么 返回-1
 * 2.数组长度为0 那么 返回数组长度
 * 3.数组的最后一个数字都比target小 那么返回数组长度
 *
 * 其他情况 数字存在在数组中 或者是
 *         数字不存在在数组中，但是 最后一个值 是比target的值大的
 *         那么使用二分的模板但只能使用模板一 更新mid也就是找有区间的第一点
 *
 *
 * 关于check函数的问题  nuns[mid] >= target
 * 那么该如何思考这个题呢？ 为什么只能用一 也即是 mid >= target
 * 可以想 如果这个数组存在的话 那么返回这个数字
 * 如果这个数字不存在的话 那么找到的肯定是比这个数字第一个大的位置作为下标插入的位置
 *
 *
 * 如果使用check mid <= target
 * 数字存在 找到的是 相同的
 * 数字不存在 找到的是 比目标值小的第一个 所以不应该使用这个方法
 *
 *
 * 那么根据使用check函数 选择的是右区间里面的第一个 所以使用模板一
 */

//35. 搜索插入位置
public class searchInsert {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6};
        System.out.println(searchInsert(arr, 3));
    }


    /**
     * 使用模板一的做法  找的其实是 右区间的最后一个点
     * @param nums
     * @param target
     * @return
     */
    public  static int searchInsert(int[] nums, int target) {
        //特例判断
        // 如果数组为空是一种边界  另一种是 如果数数组的最后一个数字都小于target
        // 那么返回数组的长度
        if(nums == null) return -1;
        if(nums .length == 0 || nums[nums.length -1] < target) return nums.length;

        int left = 0;
        int right = nums.length -1;
        while(left < right){
            int mid = (left + right) /2;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    /**
     * 使用模板二的做法 找到是左区间的最后一个点
     *
     * 但是采用模板二 确实做不出来
     * 1356  target = 2
     * 但是返回的下标是0  但是我需要返回1
     *
     *
     * 使用错误的check函数 是得不到正确的解法的
     *
     */

    public  static int searchInsert2(int[] nums, int target) {
        //特例判断
        // 如果数组为空是一种边界  另一种是 如果数数组的最后一个数字都小于target
        // 那么返回数组的长度
        if(nums == null) return -1;
        if(nums .length == 0 || nums[nums.length -1] < target) return nums.length;

        int left = 0;
        int right = nums.length -1;
        while(left < right){
            int mid = (left + right+1) /2;
            if(nums[mid] <= target){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return left;
    }

}
