package Leetcode;

//63. 不同路径 II
public class uniquePathsWithObstacles {

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid[0].length == 0){
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] dp = new int[m][n];

        //初始化设置为1
        dp[0][0] = 1;

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                //如果是障碍物
                if(obstacleGrid[i][j] == 1){
                    //需要跳过 或者置为0
                    dp[i][j] = 0;// 表示不可达 下一个不可以用整个坐标的数字同时跳过
                    continue;
                }
                if(i > 0) dp[i][j] += dp[i-1][j];//说明可以从上面过来
                if(j > 0) dp[i][j] += dp[i][j-1];//说明可以从左边过来
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * dp[i][j] 表示从所有从起点走到i，j 所有的路径数目
     *
     * error
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid[0].length == 0){
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int [][] dp = new int[m][n];
        //如果是左上角
        dp[0][0] = 1;

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                //如果是障碍物
                if(obstacleGrid[i][j] == 1){
                    //需要跳过 或者置为0
                    //dp[i][j] = 0;// 表示不可达 下一个不可以用整个坐标的数字
                    continue;
                }
                //首先需要判断整个点是不是边界的点
                //然后需要判断他的周围的点有没有是障碍物的 如果有 那么该方向的路径设置为0
                //你如果+1  就表示的是每走一步都+1
                if(j == 0 && i >1 ) dp[i][j] = dp[i-1][j];//最左边 只能来自于上方
                if(i == 0&& j > 1) dp[i][j] = dp[i][j-1];//最上边 只能来自于左边
                else {
                    //不能这样写 如果是 i== 0 j == 0 就会进入到整个逻辑里面来
                    dp[i][j] = dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
