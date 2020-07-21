import java.util.Scanner;

public class UsersLogin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("用户登录界面");
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入您的用户名：");
            String userName = scan.next();
            System.out.println("请输入您的密码");
            String password = scan.next();
            if (userName.equals("Aisen") && password.equals("FeiFei")){
                System.out.println("登陆成功");
                break;
            }else {
                System.out.println("密码错误，请重新输入！您还有" + (3-i-1) +"次机会！");
            }
        }
    }
}
