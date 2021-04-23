

public class solution {
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return method(postorder,0,postorder.length-1);
        }
        public boolean method(int[] postorder,int i,int j){
            if(i >= j)return true;
            int p = i;
            while(postorder[p] < postorder[j])p++;
            int m = p;
            while(postorder[p] > postorder[j])p++;
            return p == j && method(postorder,i,m-1) && method(postorder,m,j-1);
        }
    }
}
