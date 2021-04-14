public class Solution21_0414 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (method(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }
    public static boolean method(TreeNode A,TreeNode B){
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return method(A.left,B.left) && method(A.right,B.right);
    }
}