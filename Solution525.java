<<<<<<< HEAD
package code_2020_1215;
//525题，连续数组
import java.util.HashMap;
import java.util.Map;

public class Solution525 {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int maxLen = 0,count = 0;
        for(int i = 0;i < nums.length;i++){
            count = count + (nums[i] == 1 ? 1 : -1);
            if(map.containsKey(count)){
                maxLen = Math.max(maxLen,i - map.get(count));
            }else{
                map.put(count,i);
            }
        }
        return maxLen;
    }
}
=======
package code_2020_1215;
//525题，连续数组
import java.util.HashMap;
import java.util.Map;

public class Solution525 {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int maxLen = 0,count = 0;
        for(int i = 0;i < nums.length;i++){
            count = count + (nums[i] == 1 ? 1 : -1);
            if(map.containsKey(count)){
                maxLen = Math.max(maxLen,i - map.get(count));
            }else{
                map.put(count,i);
            }
        }
        return maxLen;
    }
}
>>>>>>> 9cd92bbcf1be9037d8db6c0c8513e1a2298c42c1
