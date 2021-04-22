public class T1 {
    public static void main(String[] args) {
        String a = "abbaca";
        System.out.println(removeDuplicates(a));
        String b = "ca";

    }

    //字符串 删除重复项

    //写一个方法 判断里面是否有相邻的重复字符串，然后返回
    //如果有相邻的字符串就进行删除的操作
    //上述的做法需要不断的重复 设置一个标志位进行处理
    public  static String removeDuplicates (String S) {
        //由于需要不断的对字符串进行更改，所以需要一个可变的字符串
        StringBuilder sb = new StringBuilder(S);

        int length = sb.length();;
        int slow = 0;
        int fast = 1;
        while (fast < length){
            length = sb.length();
            if(sb.charAt(slow) == sb.charAt(fast)){
                String temp = sb.substring(0,slow)+sb.substring(fast+1,length);
                sb = new StringBuilder(temp);
                fast = 1;
                slow = 0;
            }else {
                fast++;
                slow++;
            }
        }
        return sb.toString();


    }

}
