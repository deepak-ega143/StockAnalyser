import java.util.*;

class LoginCredentials {
    static Scanner sc = new Scanner(System.in);
    static String username = null;
    String password = null;
    String Email = null;
    String phoneNumber = null;
    static String[][] ExistingUserData = StaticUserData.userData;

    public static String login() {
        System.out.println("Enter UserName");
        String userName = sc.next();
        username = userName;
        System.out.println("Enter Password");
        String password = sc.next();
        for (int i = 0; i < ExistingUserData.length; i++) {
            if (ExistingUserData[i][3].equals(userName) && ExistingUserData[i][1].equals(password)) {
                return "Login Successfull";
            }
        }
        return "Invaild Credentials";
    }
}