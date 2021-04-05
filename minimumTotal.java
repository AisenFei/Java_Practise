package Leetcode;

import java.util.List;

//120. 三角形最小路径和
public class minimumTotal {
    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        //开辟数组的大小，无法做到动态的形式
        int[][] dp = new int[n][n];

        //初始化状态
        dp[0][0] = triangle.get(0).get(0);

        for(int i = 1 ;i < n;i++){
            for(int j = 0; j <= i;j++){
                dp[i][j] = Integer.MAX_VALUE;
                if(j > 0) dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle.get(i).get(j);
                //但是情况需要考虑 i-1 和 j-1 可能越界
                if(j == 0) dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                if(j == i) dp[i][j] = dp[i-1][j-1]+triangle.get(i).get(j); //如果是最右边的，只能是从左边下来的
                //这里是常规的状态转移方程

            }
        }

        //之后遍历一遍最后一行记录数据数组 进行更新最小值
        int res  = Integer.MAX_VALUE;
        for(int j = 0;j < n;j++){
            res = Math.min(res,dp[n-1][j]);
        }
        return res;
    }
}
