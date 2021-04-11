package Leetcode;

//198. 打家劫舍

/**
 * 给定一个数组 从中尽可能选择出不相邻的数据 可以使得和最大
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * dp [i] 表示的是最后一个选择的是数组的第i号元素
 *

 */
public class rob {
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,9,3,1};
        System.out.println(rob4(arr));

    }
    /**
     * 优化版：
     * 滚动数组
     * 结果只和dp[i] 的前两项有关
     */


    public static int rob4(int[] nums) {
        if(nums == null && nums.length == 0 ){
            return 0;
        }
        if(nums.length ==1 ){
            return nums[0];
        }
        int length = nums.length;
        int[] dp = new int[2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        int count = 0;
        for(int i = 2; i < length;i++){
            //是整个dp的数组 依次往前滚动
            int temp = dp[0];
            dp[0] = dp[1];
            dp[1] = Math.max(dp[1],temp+nums[i]);
        }
        return dp[1];
    }
    /**
     * dp[i] 表示前i间房屋可以偷窃到的最高的总金额数
     * 属性就是max
     * 对于第i间房屋可以选择偷或者不偷
     *
     * 如果偷
     * dp[i] = dp[i-2] + nums[i]
     * 如果不偷
     * dp[i] = dp[i-1]
     * 所以状态转移方程
     * dp = max (dp[i-2]+ nums[i] , dp[i-1)
     *
     * 边界条件就是
     * dp[0] = nums[0]
     * dp[1] = max (nums[0],nums[1])
     *
     *  @param nums
     * @return
     */
    public static int rob3(int[] nums) {
        if(nums == null && nums.length == 0 ){
            return 0;
        }
        if(nums.length ==1 ){
            return nums[0];
        }
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[length-1];
    }


    /**
     * 用了两个数组来表示
     * 发
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        return -1;
    }

    /**
     * error
     * 你只是考虑了第一个不相邻的 但其实的意思是 只要不相邻都可以
     * 可以是第一个和最后一个
     * 这里的dp[i] 表示的是最后一个选择是i的 金额总和
     *
     * 最后对dp数组进行遍历得到最大的数据
     *
     * @param nums
     * @return
     */
    public static int rob1(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        for(int i = 0; i< length;i++){
            if(i >= 2) dp[i] = dp[i-2]+nums[i];
            else {
                dp[i] = nums[i];
            }
        }

        int max = 0;
        for(int i = 0;i < length;i++){
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
