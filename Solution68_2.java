package binaryTree;

public class Solution68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p == root || q == root)return root;
        boolean pInLeft = search(root.left,p);
        boolean qInLeft = search(root.left,q);
        if(pInLeft && qInLeft) return lowestCommonAncestor(root.left,p,q);
        if(!pInLeft && !qInLeft) return lowestCommonAncestor(root.right,p,q);
        return root;
    }
    public static boolean search(TreeNode root,TreeNode p){
        if(root == null) return false;
        if(root.value == p.value) return true;
        if(search(root.left,p)){
            return true;
        }
        return search(root.right,p);
    }
}
