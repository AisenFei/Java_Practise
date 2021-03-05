package array;

import java.util.HashMap;
import java.util.Map;

//出现次数超过一半的数字
public class majorityElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(arr));
    }
    public  static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int halfLength = nums.length/2;
        for(int e :nums){
            map.put(e,map.getOrDefault(e,0)+1);
            int cur = map.get(e);
            if(cur> halfLength )
                return e;
        }
        return -1;
    }
}
