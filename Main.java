import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter 1 for Login");
    System.out.println("Enter 2 for SignUp");
    System.out.println("Enter 3 for DeleteAccount");
    int n = sc.nextInt();
    if (n == 1) {
      int loginCount = 0;
      LoginCredentials obj = new LoginCredentials();
      String loginInformation = obj.login();
      if (loginInformation.equals("Invaild Credentials")) {
        while (loginCount < 3 && !loginInformation.equals("Login Successfull")) {
          loginInformation = obj.login();
          loginCount++;
        }
      }
      if (loginInformation.equals("Invaild Credentials")) {
        System.out.println("Limit Reached Please Try Again Later!");
      } else {
        System.out.println(loginInformation);
      }
    } 
  }
}    

    
  