package day03;

public class isPalindrome {
    //121
    //1221
    public boolean solution (int x) {
        //负数肯定不是
        //如果末尾是0 要想回文首位必须是0 只有0 才可以
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reverseNum = 0;
        //取数字的一半
        //如何直到是否取出来数字的一半
        //当翻转的数组 >= x的时候就知道了 == 偶数翻转一半肯定位数是一样的
        while (x > reverseNum) {
            int temp = x % 10;
            reverseNum = reverseNum * 10 + temp;//将取出来的数字不断的进行*10 的操作
            x /= 10;
        }
        //跳出循环说明已经翻转了一半了
        //偶数就比较x 和 reverseNum
        //奇数比较 x 和 reverseNum/10
        return x == reverseNum || x == reverseNum / 10;
    }






    /**
     * 需要额外的空间
     */
    public boolean solution1 (int x) {
        String str = String.valueOf(x);
        int left = 0;
        int right = str.length()-1;
        while(left <= right){
            //取出字符串的左右字符
            //charAt
            //if(str.indexOf(left) )
            char a = str.charAt(left);
            char b = str.charAt(right);

            if(! (a== b) ){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

//     if(! (str.charAt(left).equals(str.charAt(right))) ){
//        return false;
//    }
}
