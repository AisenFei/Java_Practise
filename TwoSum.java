package Map;
/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

 */
import java.util.Map;
import java.util.TreeMap;

public class TwoSum {
    public int[] twoSum(int[] nums,int target){
        //用map来建立每一个数值和下标的对应关系；
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i = 0;i < nums.length;i++){
            int n = nums[i];
            int x = target - n;
            //通过target - 每一个数组中的值，来寻找是否存在该可以凑成相加之和为target的两个数
            if(map.containsKey(x)){
                int dex = map.get(x);
                return new int[] {dex,i};
            }
            map.put(n,i);
        }
        return new int[] {0,0};
    }
}
