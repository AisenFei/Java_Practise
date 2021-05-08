package BinaryTree.Practice;

public class SomeMethods {
    public static void main(String[] args) {

    }

//    求树中是否包含某一个v

    /*
    返回对应的结点
     */
    public static TreeNode contains2(TreeNode root,int v){
        if(root == null) return null;
        if(root.val == v) return root;
        //如果根结点不是，那么就去左右子树的分别去找
        //如果左右子树都右的话怎么办，返回哪一个
        //先去左子树里面找

        TreeNode res = null;
        if((res = contains2(root.left,v) )!= null) {
            return res;
        }else{   //再去右子树里面找
            return contains2(root.right,v);
        }


    }

    /*
    返回是否存在
     */
    public static boolean contains1(TreeNode root,int v){
        if(root == null) return false;
        if(root.val == v) return true;
        //如果根结点不是，那么就去左右子树的分别去找
        return contains1(root.left,v) || contains1(root.right,v);
    }

    /*求树的高度
     */
    public int maxDepth(TreeNode root) {
        //求树的高度
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        //当前树的高度+1 然后再去找左右结点树的最大高度
        return Math.max( maxDepth(root.left) ,maxDepth(root.right) )+ 1;

    }

//    求第k层的结点个数

    /**
     * 使用汇集的思路
     * 求这个树的第四层，相当于以这颗树的左右子树的为根节点就第三层
     *
     */
    public static int getKLevelSize(TreeNode root,int k){
        if(root == null) return 0;// 如果是空树，不管k是几，一律返回0。
        //不是空树 并且求得是第一层的的那么就返回以
        if(k == 1) return 1;
        //这里会处理两种情况 一个当前这个就是一个叶子结点，没有左右子树
        //不是叶子结点，分别求左右子树第k-1层的个数
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }

//    求叶子结点的个数
    /**
     *使用递归遍历的思路
     */
    private static int n;
    public static int sumTreeLeafNodeSize(TreeNode root){
        //由于可能会涉及到这个方法的所调用
        //所以每次递归之前都归为0
        if(root == null) return 0;
        if(root.left == null && root .right == null) n++;
        sumTreeLeafNodeSize(root.left);
        sumTreeLeafNodeSize(root.right);
        return n;
    }

    /**
     * 递归汇集的思路
     */

    public static int sumTreeLeafNodeSize2(TreeNode root){
        //由于可能会涉及到这个方法的所调用
        //所以每次递归之前都归为0
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return sumTreeLeafNodeSize2(root.left)+sumTreeLeafNodeSize2(root.right);
    }

}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int  x){
        val = x;
    }


}
