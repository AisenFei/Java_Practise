package String;

//蘑菇街一面笔试题
//796. 旋转字符串
public class rotateString {
    /**
     * 把字符串复制完整的一遍 进行遍历字符串的长度的次数 比较的长度是确定的
     */
    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString("", "cdeab"));
        System.out.println(rotateString("gh", "cdeab"));
    }
    public static boolean rotateString(String A, String B) {
        if(A .equals("") && B.equals("")) return true;
        if(A.equals("") || B.equals("")) return false;
        int length = A.length();
        String compact = A+A;
        for(int i = 0; i< length;i++){
            String sub = compact.substring(i,i+length);
            if(sub.equals(B)) return true;
        }
        return false;

    }


    /**
     * 扩展学习
     * 判断一个串是否为另一个串的子串的最优时间复杂度的算法是 KMP 算法。
     * 和方法二相同，我们只需要用 KMP 算法判断 B 是否为 A + A 的子串即可
     * 但是这个有点难理解
     * 参考 lc 28 题
     */



    /**
     * 一个比较low的做法
     * 字符串依次的截取和拼接模拟字符串的旋转
     * 判断是否和b相等即可
     */
    public boolean rotateString1(String A, String B) {
        if(A.equals("") && B.equals("")) return true;
        //这个能不能用下面的做法来代替
        if(A.length() == 0 &&  B.length() == 0) return true;

        if(A.equals(B)) return true;
        if(A.length() == 0 || B.length() == 0) return false;
       /* char[] arr = A.toCharArray();
        //这样转成成的链式的数据类型是 char[] 数组的数据类型
        List<char[]> chars = Arrays.asList(arr);*/

        //用字符串拼接的做法 不断的对字符串进行截取的操作 然后把前面截取的拼接到后面截取的之后即可
        int length = A.length();
        for(int i = 0; i < length;i++){
            String first = A.substring(0,i);
            String last = A.substring(i);
            String rotate = last + first;
            if (rotate.equals(B)) {
                return true;
            }
        }
        return false;
    }
}
