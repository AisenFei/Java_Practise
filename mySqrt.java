/**
 * 69. x 的平方根
 *
 * 采用的是模板二的解法
 * 更新mid 下标的方式是  对下标进行一个上取整
 * int mid = (left + right + 1 )/2
 *
 * 找区间的二段性  t*t <= x 也就是要找满足条件的最后一个点
 * 如果中间值 mid 满足这个条件 那么下标的更新方式 left = mid
 * 不满足                                    right = mid - 1
 *
 * 解释为什么一定要进行一个上取整的做法
 * 如果只有两个数字
 * 下标对应的是 0 1    mid = (left + right)  / 2 = 0
 * mid 满足小于等于的条件  那么 left = mid = 0
 * 相当于是下标没有变化，没有进行一个更新的操作 会陷入一个死循环
 * mid = (left + right + 1) /2
 *
 */

public class mySqrt {

    /**
     * 在模板二的基础上  需要考虑数字会不会越界和溢出
     * 包括这个题目选择以什么条件来作为二段性的区分 也是重要的
     *
     * 比如就不可以使用 t* t >= x  这样来进行分段的条件选择就不好
     * 如果x恰好是一个平方数子 不满足区间和满足区间   1  ~ 根号x-1   根号x ~ x
     * 如果x不是一个平方数字  不满足区间和满足区间   1 ~ 根号下取整     根号下取整 +1~ x
     * 比如 8                                   1 ~ 2           3~ 8
     *
     *
     * 注意事项 有可能会出现越界的问题
     * mid * mid <= x
     * 所以使用
     * mid <= x /mid
     *
     */
    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
    }
    public  static int mySqrt(int x) {
        int left = 0;
        int right = x;
        while(left < right){
            //这里的做法是为了防止数据的溢出
            int mid = (int) (left + (long)(right+1)) /2;
            //为什么写这个解决不了溢出的问题 就是因为 刚开始你的left = 0 所以 最大值的+1 -0 转换成left肯定溢出
            //int mid = (int) (left + ((long)(right+1) - left)/2);
            //这里这样写的原因是害怕mid * mid整形溢出的问题
            if( mid <= (x /mid)){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}
