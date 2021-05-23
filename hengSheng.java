//恒生设计算法题 其实一点都不难 但是是使用纯文本来敲代码
//其实就是考量的是代码人员的认真仔细程度 毕竟是一个 金融类型的公司
import java.util.*;
public class hengSheng {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String changeStr = change(str);
        System.out.println( str +"改变后" + changeStr);
    }
    public  static String change(String str) {
        char[] arr = new char[10];
        for (int i = 0; i <= 9; i++) {
            arr[i] = (char) ('A' + i);
        }
        char[] originalArr = str.toCharArray();
        for (int i = 0; i < originalArr.length; i++) {
            if (originalArr[i] < 'A' || originalArr[i] > 'Z') {
                //把数字转换成对应的大写字母
                originalArr[i] = arr[originalArr[i] - 48];  //这里忘记处理了  0 对应的ascii码是48
            }
        }
        return Arrays.toString(originalArr);
    }
}
