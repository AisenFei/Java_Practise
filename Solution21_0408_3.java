public class Solution21_0408_3 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int[] map = new int[256];
        int left = 0,right = -1;
        int ans = 0;
        while(left < len){
            if(right+1 < len && map[s.charAt(right+1)] == 0){
                right++;
                map[s.charAt(right)]++;
            }else{
                map[s.charAt(left)]--;
                left++;
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}
