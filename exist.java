package DFS;

//剑指 Offer 12. 矩阵中的路径
public class exist {
    /**
     * 深度优先搜索 ： 先暴力遍历矩阵中的所有字符串
     * dfs 递归，先朝一个方向搜索到底，然后回溯至上一个结点 沿另一个方向搜索 依次类推
     *
     * 剪枝 ： 在搜索的过程中 如果遇到了和目标字符不匹配的情况（也就是dfs退出条件），立即返回
     * @param board
     * @param word
     * @return
     */

    public boolean exist(char[][] board, String word) {
        //将字符串转换为字符数组
        char[] arr = word.toCharArray();

        //然后遍历board当中的所有元素 对每一个元素都进行深度优先遍历
        int level = board.length;
        int column = board[0].length;
        for(int i = 0;i < level;i++) {
            for (int j = 0; j < column; j++) {
                boolean flag = dfs(board, arr, i, j, 0);
                //这里相当于就是一个剪枝的过程
                if (flag) return true;
            }
        }
        return  false;
    }

    private boolean dfs(char[][] board, char[] arr, int i, int j, int k) {
        //不断递归的条件

        //停止的条件 --
        // 索引越界  / 字符串不匹配
        if(i < 0 || i >= board.length ||j < 0 || j >= board[0].length||board[i][j] != arr[k]) return false;

        //递归停止的条件 最后一个字符串都已经匹配了，说明可以返回结果了 不需要继续递归了否则会越界
        if(k == arr.length - 1) return true;
        //说明第一个字符已经可以正确的进行匹配 对这个字符进行标记 防止之后 其他字符搜索到这个字符
        //为什么要标记成 \0呢？ -- 表示字符  ‘\0’是字符串来结束标志位  对应ascii 码：00；  ‘0’是字符0  对应ascii 码：30
        board[i][j] = '\0';

        //然后对这字符的上下左右 进行深度优先搜索 看看是否和之后的字符相等
        //关于到底上下左右谁写在前面的问题是 由于|| 运算符一个true 都是true 那么 谁写在前面 其实变相的决定了 运行时间
        boolean res = dfs(board,arr,i-1,j,k+1) || dfs(board,arr,i+1,j,k+1) ||
                dfs(board,arr,i,j+1,k+1) || dfs(board,arr,i ,j-1,k+1);

        //每一个搜索的结果返回之后 都要把这个值重新放回去
        board[i][j] = arr[k];

        return res;
    }
}
