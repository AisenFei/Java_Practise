package code_2021_0119;

public class Solution1480 {
    public int[] runningSum(int[] nums) {
        for(int i = 1;i < nums.length;i++){
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
